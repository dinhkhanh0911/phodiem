package com.nhom2.phodiem.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom2.phodiem.entity.Person;

public interface KhoaRepository extends JpaRepository<Person,Integer> {

}
