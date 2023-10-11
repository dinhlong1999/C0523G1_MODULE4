package com.example.seminar_test2.service;

import com.example.seminar_test2.model.Origin;
import com.example.seminar_test2.repository.IOriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginService implements IOriginService{
    @Autowired
    private IOriginRepository originRepository;
    @Override
    public List<Origin> findAll() {
        return originRepository.findAll();
    }
}
