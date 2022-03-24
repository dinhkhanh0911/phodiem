package com.nhom2.phodiem.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom2.phodiem.entity.Position;
public interface PositionRepository extends JpaRepository<Position,Integer> {

}
