package com.codegym.service.impl;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicalRepository;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {

    @Autowired
    private IMedicalRepository iMedicalRepository;

    @Override
    public List<String> listBirthYear() {
        return iMedicalRepository.listBirthYear();
    }

    @Override
    public List<String> listGender() {
        return iMedicalRepository.listGender();
    }

    @Override
    public List<String> listNation() {
        return iMedicalRepository.listNation();
    }

    @Override
    public List<String> listTravelInformation() {
        return iMedicalRepository.listTravelInformation();
    }

    @Override
    public List<Medical> findAll() {
        return iMedicalRepository.findAll();
    }

    @Override
    public void addMedical(Medical medical) {
        iMedicalRepository.addMedical(medical);
    }

    @Override
    public void deleteMedical(String idCard) {
        iMedicalRepository.deleteMedical(idCard);
    }

    @Override
    public Medical findByIdCard(String idCard) {
        return iMedicalRepository.findByIdCard(idCard);
    }

    @Override
    public void editMedical(Medical medical) {
        iMedicalRepository.editMedical(medical);
    }

    @Override
    public List<String> listYear() {
        return iMedicalRepository.listYear();
    }

    @Override
    public List<String> listMonth() {
        return iMedicalRepository.listMonth();
    }

    @Override
    public List<String> listDay() {
        return iMedicalRepository.listDay();
    }

    @Override
    public List<String> listYearEnd() {
        return iMedicalRepository.listYearEnd();
    }

    @Override
    public List<String> listMonthEnd() {
        return iMedicalRepository.listMonthEnd();
    }

    @Override
    public List<String> listDayEnd() {
        return iMedicalRepository.listDayEnd();
    }
}
