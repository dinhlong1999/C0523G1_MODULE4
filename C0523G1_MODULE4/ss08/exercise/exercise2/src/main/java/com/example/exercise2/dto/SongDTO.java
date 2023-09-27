package com.example.exercise2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDTO implements Validator {
    private int id;

    private String name;
    private String singer;
    private String kindOfMusic;

    public SongDTO(int id, String name, String singer, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
    }


    public SongDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        if (songDTO.getName().equals("")) {
            errors.rejectValue("name", null, "Song title cannot be empty");
        } else if (!songDTO.getName().matches("^[^@;,.=+\\-...]{1,800}$")) {
            errors.rejectValue("name", null, "Must not contain special characters");
        } else if (songDTO.getSinger().equals("")) {
            errors.rejectValue("singer", null, "Singer title cannot be empty");
        } else if (!songDTO.getSinger().matches("^[^@;,.=+\\-...]{1,300}$")) {
            errors.rejectValue("singer", null, "Must not contain special characters");
        }else if (songDTO.getKindOfMusic().equals("")){
            errors.rejectValue("kindOfMusic",null,"Kind of music title cannot be empty");
        } else if (!songDTO.getKindOfMusic().matches("^[A-Z0-9a-z,//s]{1,1000}$")) {
            errors.rejectValue("kindOfMusic", null, "Must not contain special characters");
        }
    }
}