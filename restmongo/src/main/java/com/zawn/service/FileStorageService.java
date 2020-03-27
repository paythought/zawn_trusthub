package com.zawn.service;

import java.nio.file.Path;

import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.multipart.MultipartFile;

import com.zawn.domain.Users;
import com.zawn.dto.DownloadFileRequest;
import com.zawn.dto.UploadFileRequest;


public interface FileStorageService {

		void init();
				
		String store(UploadFileRequest fileRequest, boolean overwrite);
		
		Stream<Path> loadAll(DownloadFileRequest fileRequest);

		Path load(String filename);
		
		Resource loadAsResource(DownloadFileRequest fileRequest);
		
		void delete(DownloadFileRequest fileRequest);
		
		void deleteAll();

}
