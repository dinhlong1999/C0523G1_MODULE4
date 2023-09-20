package com.example.exercise1.service;

import com.example.exercise1.model.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> getAll();
    Mail searchMail(int id);
    void editConfig(Mail mail);

    int findIndex(int id);
}
