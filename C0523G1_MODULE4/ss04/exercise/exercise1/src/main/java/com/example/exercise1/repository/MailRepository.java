package com.example.exercise1.repository;

import com.example.exercise1.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailRepository implements IMailRepository {
    private static List<Mail> mailList = new ArrayList<>();
    static {
        mailList.add(new Mail(1,"English",25,true,"THOR - 0932533481"));
        mailList.add(new Mail(2,"Vietnamese",50,false,"Long - 0783685099"));
    }

    @Override
    public List<Mail> showAll() {
        return mailList;
    }

    @Override
    public Mail searchMail(int id) {
        for (Mail mail: mailList ) {
            if (mail.getId() == id){
                return mail;
            }
        }
        return null;
    }

    @Override
    public void editConfig(int id, Mail mail) {
        mailList.set(id,mail);
    }

    @Override
    public int findIndex(int id) {
        for (int i = 0; i < mailList.size(); i++) {
            if (mailList.get(i).getId() == id){
                return i;
            }

        }
        return 0;
    }
}
