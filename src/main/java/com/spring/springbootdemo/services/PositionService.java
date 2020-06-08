package com.spring.springbootdemo.services;

import com.spring.springbootdemo.enity.Position;

import java.util.List;

public interface PositionService {

    boolean addPosition(Position position);

    boolean updatePosition(Position position);

    boolean deleteById(Long id);

    Position findById(Long id);

    List<Position> findAll();

}
