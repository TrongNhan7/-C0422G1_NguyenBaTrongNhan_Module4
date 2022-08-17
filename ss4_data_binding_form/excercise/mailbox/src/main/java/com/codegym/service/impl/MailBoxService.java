package com.codegym.service.impl;

import com.codegym.model.MailBox;
import com.codegym.repository.IMailBoxRepository;
import com.codegym.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxService implements IMailBoxService {

    @Autowired
    private IMailBoxRepository iMailBoxRepository;


    @Override
    public List<MailBox> findAll() {
        return iMailBoxRepository.findAll();
    }

    @Override
    public void addMailBox(MailBox mailBox) {
        iMailBoxRepository.addMailBox(mailBox);
    }

    @Override
    public List<String> listLanguages() {
        return iMailBoxRepository.listLanguages();
    }

    @Override
    public List<String> listLPageSize() {
        return iMailBoxRepository.listLPageSize();
    }
}
