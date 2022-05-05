package com.nhom2.phodiem;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.nhom2.phodiem.api.positionApi;
import com.nhom2.phodiem.entity.Position;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;


@SpringBootTest
@Transactional
public class TestPositionApi {

	@Autowired
	positionApi pApi;
	
	@Autowired 
	Validator validator;
	
	//Thêm thành công
	@Test
	public void testAddPositionSuccess() {
		Position position = new Position("Bảo vệ","NV-0001");
		BindingResult mockBindingResult = new BeanPropertyBindingResult(position,"objectName");
		validator.validate(position, mockBindingResult);
		ResponseEntity<ResponseObject>  result = pApi.addPosition(position, mockBindingResult);
		assertEquals(result.getStatusCodeValue(), 200);
	}
	
	//Thêm thất bại
	
	@Test
	public void testAddFailedPosition() {
		Position position = new Position("","NV-0001");
		BindingResult mockBindingResult = new BeanPropertyBindingResult(position,"objectName");
		validator.validate(position, mockBindingResult);
		ResponseEntity<ResponseObject>  result = pApi.addPosition(position, mockBindingResult);
		assertEquals(result.getStatusCodeValue(), 400);
	}
}
