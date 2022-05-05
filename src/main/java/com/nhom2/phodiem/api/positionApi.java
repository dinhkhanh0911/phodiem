package com.nhom2.phodiem.api;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.phodiem.entity.Position;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.PositionRepository;

import antlr.collections.List;

@RestController
@RequestMapping(path = "/api/v1/positions")
public class positionApi {
	
	@Autowired
	PositionRepository repository;
	
	@GetMapping("")
	public ResponseEntity<ResponseObject> findAll(){
		ArrayList<Position> listPositons = (ArrayList<Position>)repository.findAll();
		
		if(listPositons.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Tim kiem thanh cong",listPositons)
				);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject(404,"Tim kiem that bai","")
				);
		}
	}
	@PostMapping("")
	public ResponseEntity<ResponseObject> addPosition(@Valid @RequestBody Position position,BindingResult bindingResult){
		
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ResponseObject(400,"Thêm thất bại",bindingResult.getAllErrors())
			);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Thêm thành công",repository.save(position))
			);
		}
	}
}
