package com.hcl.ingproduct.service;

import org.springframework.web.multipart.MultipartFile;

import com.hcl.ingproduct.dto.UploadFileResponseDto;

public interface UploadService {

	public UploadFileResponseDto uploadFile(MultipartFile file);
}
