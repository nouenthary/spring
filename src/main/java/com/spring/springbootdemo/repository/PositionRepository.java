package com.spring.springbootdemo.repository;

import com.spring.springbootdemo.enity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {

}
