package com.codegym.repository.impl;

import com.codegym.model.MailBox;
import com.codegym.repository.IMailBoxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailboxRepository implements IMailBoxRepository {

    private static List<String> listLanguages = new ArrayList<>();
    private static List<String> listPageSize = new ArrayList<>();
    private static List<MailBox> listMailBox = new ArrayList<>();

    static {
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");
        listPageSize.add("5");
        listPageSize.add("10");
        listPageSize.add("15");
        listPageSize.add("20");
        listPageSize.add("50");
        listPageSize.add("100");
    }


    @Override
    public List<MailBox> findAll() {
        return listMailBox;
    }

    @Override
    public void addMailBox(MailBox mailBox) {
        listMailBox.add(mailBox);
    }

    @Override
    public List<String> listLanguages() {
        return listLanguages;
    }

    @Override
    public List<String> listLPageSize() {
        return listPageSize;
    }

}
