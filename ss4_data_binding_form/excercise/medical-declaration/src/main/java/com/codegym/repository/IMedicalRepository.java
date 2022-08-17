package com.codegym.repository;

import com.codegym.model.Medical;

import java.util.List;

public interface IMedicalRepository {

    List<Medical> findAll();

    void addMedical(Medical medical);

    void deleteMedical(String idCard);

    Medical findByIdCard(String idCard);

    void editMedical(Medical medical);

    List<String> listBirthYear();

    List<String> listGender();

    List<String> listNation();

    List<String> listTravelInformation();

    List<String> listYear();

    List<String> listMonth();

    List<String> listDay();

    List<String> listYearEnd();

    List<String> listMonthEnd();

    List<String> listDayEnd();

}
