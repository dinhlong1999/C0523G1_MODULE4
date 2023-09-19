package com.example.exercise1.repository;

import com.example.exercise1.model.Mail;

import java.util.List;

public interface IMailRepository {
    List<Mail> showAll();
    Mail searchMail(int id);
    void editConfig(int id, Mail mail);
    int findIndex(int id);
}
