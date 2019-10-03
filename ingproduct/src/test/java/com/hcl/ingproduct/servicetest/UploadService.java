package com.hcl.ingproduct.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.ingproduct.service.UploadServiceImpl;
import com.hcl.ingproduct.util.ExcelImportToDB;

@RunWith(SpringJUnit4ClassRunner.class)
public class UploadService {

	@InjectMocks
	UploadServiceImpl uploadServiceImpl;
	
	@Mock
	private ExcelImportToDB excelImport;
	
	@Test
	public void uploadFile(MultipartFile file) {
		
	}
}
