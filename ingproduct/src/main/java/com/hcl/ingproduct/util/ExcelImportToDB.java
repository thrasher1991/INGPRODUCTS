package com.hcl.ingproduct.util;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.ingproduct.dto.UploadFileResponseDto;
import com.hcl.ingproduct.entity.Category;
import com.hcl.ingproduct.entity.Product;
import com.hcl.ingproduct.repository.CategoryRepository;
import com.hcl.ingproduct.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ExcelImportToDB {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public UploadFileResponseDto loadDataToDB(MultipartFile file) {

		UploadFileResponseDto response = new UploadFileResponseDto();
		FileInputStream input = null;
		XSSFSheet sheet = null;
		XSSFWorkbook workbook = null;
		try {

			workbook = new XSSFWorkbook(file.getInputStream());

			sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();

				
				String productName = "";
				String productDescription = "";

				Cell cell = cellIterator.next();
				Product product = new Product();
				Category category = new Category();

				String categoryName = cell.getStringCellValue();

				if (cellIterator.hasNext()) {
					Cell cell1 = cellIterator.next();
					productName = cell1.getStringCellValue();
				}

				if (cellIterator.hasNext()) {
					Cell cell2 = cellIterator.next();
					productDescription = cell2.getStringCellValue();
				}

				category.setCategoryName(categoryName);
				
				Optional<Category> categoryProduct1=categoryRepository.findByCategoryName(categoryName);
				Category categoryProduct3;
								
				if(!categoryProduct1.isPresent()) {
					categoryProduct3=categoryRepository.save(category);
				}else {
					categoryProduct3=categoryProduct1.get();
				}

				product.setCategoryId(categoryProduct3.getCategoryId());
				product.setProductDescription(productDescription);
				product.setProductName(productName);

				productRepository.save(product);

				response.setMessage("success");
				response.setStatusCode(200);

			}

		} catch (Exception e) {
			log.error(this.getClass().getName() + " loadDataToDB : " + e.getMessage());
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
				if (input != null) {
					input.close();
				}
				sheet = null;
			} catch (Exception e) {
				log.error(this.getClass().getName() + " loadDataToDB finally block : " + e.getMessage());
			}

		}
		return response;
	}

}
