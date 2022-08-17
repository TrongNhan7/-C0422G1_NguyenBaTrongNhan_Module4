package com.codegym.service;

import com.codegym.model.Medical;

import java.util.List;

public interface IMedicalService {
    List<String> listBirthYear();

    List<String> listGender();

    List<String> listNation();

    List<String> listTravelInformation();

    List<Medical> findAll();

    void addMedical(Medical medical);

    void deleteMedical(String idCard);

    Medical findByIdCard(String idCard);

    void editMedical(Medical medical);

    List<String> listYear();

    List<String> listMonth();

    List<String> listDay();

    List<String> listYearEnd();

    List<String> listMonthEnd();

    List<String> listDayEnd();
}
