package com.codegym.service;

import com.codegym.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    List<MailBox> findAll();

    void addMailBox(MailBox mailBox);

    List<String> listLanguages();

    List<String> listLPageSize();
}
