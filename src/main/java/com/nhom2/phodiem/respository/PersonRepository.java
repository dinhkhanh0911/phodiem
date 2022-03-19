package com.nhom2.phodiem.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhom2.phodiem.entity.Person;

public interface  PersonRepository extends JpaRepository<Person,Integer> {
	List<Person> findByName(String name);
	
	
	@Query("SELECT m FROM Person m WHERE m.name LIKE %:name%")
	List<Person> searchByNameLike(String name);
}
