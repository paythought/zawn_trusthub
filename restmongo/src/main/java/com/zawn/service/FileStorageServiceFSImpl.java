package com.zawn.service;


import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.zawn.conf.FileStorageProperties;
import com.zawn.domain.Users;
import com.zawn.dto.DownloadFileRequest;
import com.zawn.dto.UploadFileBox;
import com.zawn.dto.UploadFileRequest;

@Service("FileStorageService")
public class FileStorageServiceFSImpl implements FileStorageService {
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@PreAuthorize(
    		"authentication?.authenticated and (" +
    		"hasAuthority('" + UserRole.ROLE_ADMIN + "') or "
    		+ " #fileRequest?.users?.username == authentication?.name or "
    		+ "hasAuthority('" + UserRole.ROLE_COMPANY + "') and #fileRequest?.users?.idcompany?.username == authentication?.name )"
    		)
	static @interface IsPermitted {
	
	}
	
	
	
	
//	@Autowired
//	private UsersRepository userDao;
	
    private final Path fileStorageLocation;

    @Autowired
    public FileStorageServiceFSImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
    
    @IsPermitted
    @Override
    public String store(UploadFileRequest fileRequest, boolean overwrite) {
    	Users user=fileRequest.getUsers();
    	UploadFileBox filebox=fileRequest.getFilebox();
    	MultipartFile file = fileRequest.getFile();
    	//TODO Authorization
    	
    	// Create folder
    	Path subFolder=this.fileStorageLocation.
        		resolve(user.getId().toString()).resolve(filebox.toString());
    	try {
            Files.createDirectories(subFolder);
        } catch (Exception ex) {
            throw new FileStorageException(
            		String.format("Could not create the directory where the uploaded file will be stored. "
            				+ "/%s/%s/",user.getId(), filebox ), ex);
        }
    	
    	
        // Normalize file name
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = subFolder.resolve(fileName);
            if(overwrite)
            	Files.copy(file.getInputStream(), targetLocation,StandardCopyOption.REPLACE_EXISTING);
            else
            	Files.copy(file.getInputStream(), targetLocation);
            
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException(
            		String.format("Could not store file /%s/%s/%s. Please try again!" ,user.getId(), filebox ,fileName )
            		, ex);
        }
    }
    
    @IsPermitted
    @Override
    public Resource loadAsResource(DownloadFileRequest fileRequest) {
    	Users user=fileRequest.getUsers();
    	UploadFileBox filebox=fileRequest.getFilebox();
    	String filename = fileRequest.getFilename();
    	
    	//TODO Authorization
    	
    	// get folder
    	Path subFolder=this.fileStorageLocation.
        		resolve(user.getId().toString()).resolve(filebox.toString());
    	String filePathStr=String.format("/%s/%s/%s" ,user.getId(), filebox ,filename );
        try {
        	
            Path filePath = subFolder.resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new UploadedFileNotFoundException("File not found " + filePathStr);
            }
        } catch (MalformedURLException ex) {
            throw new UploadedFileNotFoundException("File not found " + filePathStr, ex);
        }
    }

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@IsPermitted
	@Override
	public Stream<Path> loadAll(DownloadFileRequest fileRequest){
		Path subDir=Paths.get(fileRequest.getUsers().getId().toString(),fileRequest.getFilebox().toString());
		
    	
//		Path subDir=this.fileStorageLocation
//				.resolve(path.getUsers().getId().toString())
//				.resolve(path.getFilebox().toString());
		Path fullPath=this.fileStorageLocation.resolve(subDir);
		if(!Files.exists(fullPath)) return (new ArrayList<Path>()).stream();
		try {
			return Files.walk(fullPath, 1);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileStorageException("Could not enumerate files beneath " + subDir + ".!", e);
		}
	}
	
	@IsPermitted
	@Override
	public void delete(DownloadFileRequest fileRequest)  {
		Users user = fileRequest.getUsers();
		UploadFileBox filebox = fileRequest.getFilebox();
		String filename = fileRequest.getFilename();

		// TODO Authorization

		// get folder
		String filePathStr = String.format("/%s/%s/%s", user.getId(), filebox, filename);
		Path filePath = this.fileStorageLocation.resolve(user.getId().toString()).resolve(filebox.toString())
				.resolve(filename).normalize();
		if(!Files.exists(filePath)) throw new UploadedFileNotFoundException("File not found " + filePathStr);
		try {
			Files.delete(filePath);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileStorageException("Deleting failed. " + filePathStr + ".!", e);
		}
	}
	
	
	@Override
	public Path load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	
}