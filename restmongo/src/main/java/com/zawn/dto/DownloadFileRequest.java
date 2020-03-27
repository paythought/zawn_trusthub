
package com.zawn.dto;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zawn.domain.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DownloadFileRequest {
	@JsonProperty("users")
    private Users users;
	@JsonProperty("filebox")
    private UploadFileBox filebox;
	@JsonProperty("filename")
	private String filename;
}