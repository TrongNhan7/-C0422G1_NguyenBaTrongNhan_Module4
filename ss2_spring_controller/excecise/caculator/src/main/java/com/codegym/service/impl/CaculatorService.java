package com.codegym.service.impl;

import com.codegym.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {

    @Override
    public double calculator(double number1, double number2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 % number2;
                break;
        }
        return result;
    }
}
