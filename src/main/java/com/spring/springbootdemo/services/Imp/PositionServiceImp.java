package com.spring.springbootdemo.services.Imp;

import com.spring.springbootdemo.enity.Position;
import com.spring.springbootdemo.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImp implements PositionService {

    @Autowired
    private PositionServiceImp positionServiceImp;

    @Override
    public boolean addPosition(Position position) {
        return positionServiceImp.addPosition(position);
    }

    @Override
    public boolean updatePosition(Position position) {
        return positionServiceImp.updatePosition(position);
    }

    @Override
    public boolean deleteById(Long id) {
        return positionServiceImp.deleteById(id);
    }

    @Override
    public Position findById(Long id) {
        return positionServiceImp.findById(id);
    }

    @Override
    public List<Position> findAll() {
        return positionServiceImp.findAll();
    }
}
