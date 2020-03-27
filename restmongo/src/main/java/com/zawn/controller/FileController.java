package com.zawn.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zawn.domain.Users;
import com.zawn.dto.DownloadFileRequest;
import com.zawn.dto.UploadFileBox;
import com.zawn.dto.UploadFileRequest;
import com.zawn.dto.UploadFileResponse;
import com.zawn.service.NotSelectUploadFileException;
import com.zawn.service.FileStorageService;
import com.zawn.service.UploadedFileNotFoundException;
import com.zawn.service.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/files")
public class FileController {

	@Autowired
	private FileStorageService fileStorageService;

	/**
	 * Overwrite if HTTP method is PUT ,and don't overwrite if POST. 
	 * 
	 * @param userId
	 * @param users
	 * @param filebox
	 * @param files
	 * @return
	 */
	@RequestMapping(value="/{users}/{filebox}", method = {RequestMethod.POST,RequestMethod.PUT} )
	@ResponseBody
	public ResponseEntity<?> uploadFile(@PathVariable(value = "users", required = true) String userId,
			@PathVariable(value = "users", required = true) Users users,
			@PathVariable(value = "filebox", required = true) UploadFileBox filebox,
			@RequestParam(value = "file", required = true) MultipartFile[] files,
			HttpServletRequest request) {
		
		RequestMethod requestMethod=RequestMethod.valueOf(request.getMethod()); 
		
		if (users == null)
			throw new UserNotFoundException(userId.toString());

		if (files == null || files.length == 0)
			throw new NotSelectUploadFileException("Not specified the file to upload.");
		try (Stream<MultipartFile> filesStream = Arrays.stream(files)) {
			filesStream.forEach(file -> {
				if (file == null || file.getOriginalFilename() == null || file.getOriginalFilename().isEmpty())
					throw new NotSelectUploadFileException("A file to upload not specified.");
			});
		}

		try (Stream<MultipartFile> filesStream = Arrays.stream(files)) {
			return ResponseEntity.ok(filesStream.map(file -> {
				String fileName = fileStorageService
						.store(UploadFileRequest.builder().users(users).filebox(filebox).file(file).build(),
								requestMethod==RequestMethod.PUT );
				String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
						.path(String.format("/files/%s/%s/%s", users.getId(), filebox, fileName)).toUriString();
				return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
			}).collect(Collectors.toList()));
		}
	}

	@GetMapping("/{users}/{filebox}/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@PathVariable(value = "users", required = true) String userId,
			@PathVariable(value = "users", required = true) Users users,
			@PathVariable(value = "filebox", required = true) UploadFileBox filebox,
			@PathVariable(value = "filename", required = true) String fileName, HttpServletRequest request) {

		if (users == null)
			throw new UserNotFoundException(userId.toString());
		if (fileName == null || fileName.isEmpty())
			throw new UploadedFileNotFoundException("Not specified file name.");

		// Load file as Resource
		Resource resource = fileStorageService
				.loadAsResource(DownloadFileRequest.builder().users(users).filebox(filebox).filename(fileName).build());

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = getContentTypeFromFilename(request.getServletContext(), resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			log.info("Could not determine file type.");
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	private String getContentTypeFromFilename(ServletContext context, String filepath) {

		String contentType = null;
		contentType = context.getMimeType(filepath);

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		return contentType;
	}

	@GetMapping("/{users}/{filebox}")
	@ResponseBody
	public List<UploadFileResponse> listUploadedFiles(@PathVariable(value = "users", required = true) String userId,
			@PathVariable(value = "users", required = true) Users users,
			@PathVariable(value = "filebox", required = true) UploadFileBox filebox, HttpServletRequest request)
			throws IOException {
		if (users == null)
			throw new UserNotFoundException(userId.toString());

		List<UploadFileResponse> fileList = fileStorageService
				.loadAll(DownloadFileRequest.builder().users(users).filebox(filebox).build())
				.filter(path -> !Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS))
				.map(path -> {
					String contentType = getContentTypeFromFilename(request.getServletContext(),
							path.getFileName().toString());
					String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
							.path(String.format("/files/%s/%s/%s", users.getId(), filebox, path.getFileName()))
							.toUriString();
					long size=-1;
					try {
						size=Files.size(path);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return new UploadFileResponse(path.getFileName().toString(), fileDownloadUri, contentType,size);
				}).collect(Collectors.toList());
		return fileList;
	}
	
	@DeleteMapping("/{users}/{filebox}/{filename:.+}")
	@ResponseBody
	public ResponseEntity<?> deleteFile(@PathVariable(value = "users", required = true) String userId,
			@PathVariable(value = "users", required = true) Users users,
			@PathVariable(value = "filebox", required = true) UploadFileBox filebox,
			@PathVariable(value = "filename", required = true) String fileName, HttpServletRequest request) {

		if (users == null)
			throw new UserNotFoundException(userId.toString());
		if (fileName == null || fileName.isEmpty())
			throw new UploadedFileNotFoundException("Not specified file name.");

		// Load file as Resource
		fileStorageService
				.delete(DownloadFileRequest.builder().users(users).filebox(filebox).filename(fileName).build());
		return ResponseEntity.noContent().build();
	}

//	@ExceptionHandler(StorageFileNotFoundException.class)
//	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//		return ResponseEntity.notFound().build();
//	}

}