package com.example.seminar_test2.service;

import com.example.seminar_test2.model.Pig;
import com.example.seminar_test2.repository.IPigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PigService implements IPigService{
    @Autowired
    private IPigRepository pigRepository;
    @Override
    public List<Pig> findAll() {
        return pigRepository.findAll();
    }

    @Override
    public void delete(int id) {
        pigRepository.deleteById(id);
    }

    @Override
    public Pig getPigById(int id) {
        return pigRepository.findById(id).get();
    }

    @Override
    public void save(Pig pig) {
        pigRepository.save(pig);
    }
}
