package com.nhom2.phodiem.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhom2.phodiem.entity.Person;
import com.nhom2.phodiem.entity.Subject;

public interface subjectRepository extends JpaRepository<Subject,Integer> {
	
	/*
	 * List<>
	 * 
	 * @Query("SELECT m FROM Person m WHERE m.name LIKE %:name%") ArrayList<Subject>
	 * searchByNameLike(long subjectId);
	 */
}
