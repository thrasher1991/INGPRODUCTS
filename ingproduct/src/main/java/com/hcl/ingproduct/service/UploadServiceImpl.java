package com.hcl.ingproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.ingproduct.dto.UploadFileResponseDto;
import com.hcl.ingproduct.util.ExcelImportToDB;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	private ExcelImportToDB excelImport;

	@Override
	public UploadFileResponseDto uploadFile(MultipartFile file) {
		return excelImport.loadDataToDB(file);
	}
}
