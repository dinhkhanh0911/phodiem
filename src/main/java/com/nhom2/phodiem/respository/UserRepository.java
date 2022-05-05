package com.nhom2.phodiem.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhom2.phodiem.entity.User;

public interface  UserRepository extends JpaRepository<User,Long> {
	
	Optional<User> findByUserName(String username);
	Optional<User> findById(long Id);
	
	
	@Query("SELECT m FROM User m WHERE m.fullName LIKE %:name% or m.identityNumber LIKE %:name%")
	List<User> searchByNameLike(String name);
}
