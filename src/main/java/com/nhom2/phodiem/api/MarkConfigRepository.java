package com.nhom2.phodiem.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhom2.phodiem.entity.MarkConfig;
import com.nhom2.phodiem.entity.Person;

public interface MarkConfigRepository extends JpaRepository<MarkConfig,Integer>  {
	
	/* @Query("SELECT m FROM MarkConfig m WHERE m.subjectId = subjectId") */
	/* List<MarkConfig> findBySubjectId(Long subjectId); */
}
