package com.nhom2.phodiem.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.Teacher;
import com.nhom2.phodiem.respository.SemesterRespository;
import com.nhom2.phodiem.respository.TeacherRepository;

public class GiaoVienApi {
	@Autowired
	TeacherRepository repositories;

	@GetMapping(value = "")
	ResponseEntity<ResponseObject> getTeacher() {

		List<Teacher> teacher = repositories.findAll();

		if (teacher.size() > 0) {

			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, "Tim kiem thanh cong", teacher));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(404, "Tim kiem that bai", ""));
		}
	}
}
