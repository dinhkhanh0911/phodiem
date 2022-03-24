package com.nhom2.phodiem.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.Semester;
import com.nhom2.phodiem.respository.SemesterRespository;

@RestController
@RequestMapping(path = "/api/v1/semester")
public class HocKyApi {
	@Autowired
	SemesterRespository repositories;

	@GetMapping(value = "")
	ResponseEntity<ResponseObject> insertPerson() {

		List<Semester> semester = repositories.findAll();

		if (semester.size() > 0) {

			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, "Tim kiem thanh cong", semester));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(404, "Tim kiem that bai", ""));
		}
	}
	@GetMapping(value = "/export")
	ResponseEntity<ResponseObject> export() throws Exception {
		
	try {
		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("Persons");
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);

		Row header = sheet.createRow(0);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBold(true);
		headerStyle.setFont(font);

		Cell headerCell = header.createCell(0);
		headerCell.setCellValue("Name");
		headerCell.setCellStyle(headerStyle);

		headerCell = header.createCell(1);
		headerCell.setCellValue("Age");
		headerCell.setCellStyle(headerStyle);
		
		CellStyle style = workbook.createCellStyle();
		style.setWrapText(true);

		Row row = sheet.createRow(2);
		Cell cell = row.createCell(0);
		cell.setCellValue("John Smith");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue(20);
		cell.setCellStyle(style);
		
		FileOutputStream outputStream = new FileOutputStream("employee.xlsx");
		workbook.write(outputStream);
		workbook.close();
		
//		InputStream finput = new FileInputStream(currDir);
//		byte[] imageBytes = new byte[100000];
//		outputStream.write(imageBytes);
//		outputStream.close();
//		String imageStr = org.apache.commons.codec.binary.Base64.encodeBase64String(imageBytes);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, "Tim kiem thanh cong", "ok"));
	
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, "Tim kiem thanh cong", e));
	}
	}
	
	
}
