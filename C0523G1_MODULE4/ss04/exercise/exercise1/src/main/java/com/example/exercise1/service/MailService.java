package com.example.exercise1.service;

import com.example.exercise1.model.Mail;
import com.example.exercise1.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService {
    @Autowired
    public IMailRepository mailRepository;
    @Override
    public List<Mail> getAll() {
        return mailRepository.showAll();
    }

    @Override
    public Mail searchMail(int id) {
        return mailRepository.searchMail(id);
    }

    @Override
    public void editConfig(int id, Mail mail) {
        mailRepository.editConfig(id,mail);
    }

    @Override
    public int findIndex(int id) {
        return mailRepository.findIndex(id);
    }
}
