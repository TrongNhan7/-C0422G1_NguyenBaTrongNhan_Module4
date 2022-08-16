package com.codegym.repository.impl;

import com.codegym.repository.ISandwichRepository;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;
import java.util.List;

@Repository
public class SandwichRepository implements ISandwichRepository {

    private static List<String> condimentsList = new LinkedList<>();

    static {
        condimentsList.add("Lettuce");
        condimentsList.add("Tomato");
        condimentsList.add("Mustard");
        condimentsList.add("Sprouts");
    }


    @Override
    public List<String> findAllCondiments() {
        return condimentsList;
    }
}
