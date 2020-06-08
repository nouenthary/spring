package com.spring.springbootdemo.controller;

import com.spring.springbootdemo.enity.Position;
import com.spring.springbootdemo.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @PostMapping
    public Position createPosition(@RequestBody Position position){
        return positionRepository.save(position);
    }

    @GetMapping("/{id}")
    public Optional<Position> findById(@PathVariable(value = "id") Long id){
        return positionRepository.findById(id);
    }

}
