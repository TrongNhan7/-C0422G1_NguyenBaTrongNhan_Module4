package com.codegym.service.impl;

import com.codegym.repository.IDictionaryRepository;
import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IDictionaryRepository iDictionaryRepository;

    @Override
    public String dictionary(String word) {
        return iDictionaryRepository.dictionary(word);
    }
}
