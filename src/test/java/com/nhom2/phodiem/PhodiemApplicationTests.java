package com.nhom2.phodiem;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.nhom2.phodiem.api.UserApi;
import com.nhom2.phodiem.entity.PhoDiemException;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.services.UserServices;

import lombok.experimental.var;
@SpringBootTest
class PhodiemApplicationTests {

	
	
//	@Test
//	void contextLoads() {
//		UserServices userServices = new UserServices();
////		int result = userServices.deleteService(2);
////		assertThrows(Pho, null)
//	}
//	
//	@Test
//	void contextLoads2() {
//		UserApi userApi = new UserApi();
//		ResponseEntity<ResponseObject> a = userApi.deleteUser(2);
//		assertTrue(a != null);
//	}

}
