package com.zawn.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.zawn.dto.UploadFileBox;
@Component
public class UploadFileBoxEnumConverter implements Converter<String, UploadFileBox>{

	@Override
	public UploadFileBox convert(String source) {
		return UploadFileBox.fromValue(source);
	}
	
}
