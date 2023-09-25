package com.example.exercise2.service;

import com.example.exercise2.model.Song;
import com.example.exercise2.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{

    @Autowired
    private ISongRepository songRepository;
    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}
