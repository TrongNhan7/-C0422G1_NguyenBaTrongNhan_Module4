package com.codegym.repository;

import com.codegym.model.MailBox;

import java.util.List;

public interface IMailBoxRepository {

    List<MailBox> findAll();

    void addMailBox(MailBox mailBox);

    List<String> listLanguages();

    List<String> listLPageSize();
}
