package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    static Map<String,String> dictionary= new HashMap<>();
    static {
        dictionary.put("Manchester United".toLowerCase(),"Mu");
        dictionary.put( "matchless".toLowerCase(),"vô đối");
        dictionary.put( "into the cave".toLowerCase(),"vào hang");
        dictionary.put( "king".toLowerCase(),"vua");
        dictionary.put( "friendly match".toLowerCase(),"giao hữu");
    }

    @Override
    public String dictionary(String keyWord) {
        return dictionary.get(keyWord.toLowerCase());
    }
}
