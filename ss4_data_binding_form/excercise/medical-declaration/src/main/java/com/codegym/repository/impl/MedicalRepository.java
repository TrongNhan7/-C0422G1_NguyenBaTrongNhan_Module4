package com.codegym.repository.impl;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {

    private static List<String> listBirthYear = new ArrayList<>();
    private static List<String> listGender = new ArrayList<>();
    private static List<String> listNation = new ArrayList<>();
    private static List<String> listTravelInformation = new ArrayList<>();
    private static List<String> listYear = new ArrayList<>();
    private static List<String> listMonth = new ArrayList<>();
    private static List<String> listDay = new ArrayList<>();
    private static List<String> listYearEnd = new ArrayList<>();
    private static List<String> listMonthEnd = new ArrayList<>();
    private static List<String> listDayEnd = new ArrayList<>();
    private static List<Medical> listMedical = new ArrayList<>();

    static {

        listMedical.add(new Medical("Trung", "1999", "Nam", "Viet Nam", "1", "đi chơi", "Car",
                123, "2019", "11", "20", "2022", "06", "11", "Da Nang"));
        listMedical.add(new Medical("Huy", "1980", "Nam", "Viet Nam", "2", "đi chơi", "Car",
                123, "2019", "11", "20", "2022", "06", "11", "Da Nang"));
        listMedical.add(new Medical("Hải", "1994", "Nam", "Viet Nam", "3", "đi chơi", "Car",
                123, "2019", "11", "20", "2022", "06", "11", "Da Nang"));
        listMedical.add(new Medical("Tín", "1997", "Nam", "Viet Nam", "4", "đi chơi", "Car",
                123, "2019", "11", "20", "2022", "06", "11", "Da Nang"));
        listBirthYear.add("1990");
        listBirthYear.add("1991");
        listBirthYear.add("1992");
        listBirthYear.add("1993");
        listGender.add("Nam");
        listGender.add("Nữ");
        listGender.add("Chưa xác định");
        listNation.add("Việt Nam");
        listNation.add("China");
        listNation.add("Ukraine");
        listTravelInformation.add("Tàu bay");
        listTravelInformation.add("Tàu thuyền");
        listTravelInformation.add("Ô tô");
        listTravelInformation.add("Khác (Ghi rõ)");

        listYear.add("2019");
        listYear.add("2020");
        listYear.add("2021");
        listYear.add("2022");

        for (int i = 1; i <= 12; i++) {
            listMonth.add("Tháng " + i);
        }

        for (int i = 1; i <= 31; i++) {
            listDay.add("Ngày " + i);
        }

        listYearEnd.add("2019");
        listYearEnd.add("2020");
        listYearEnd.add("2021");
        listYearEnd.add("2022");

        for (int i = 1; i <= 12; i++) {
            listMonthEnd.add("Tháng " + i);
        }

        for (int i = 1; i <= 31; i++) {
            listDayEnd.add("Ngày " + i);
        }
    }


    @Override
    public List<String> listBirthYear() {
        return listBirthYear;
    }

    @Override
    public List<String> listGender() {
        return listGender;
    }

    @Override
    public List<String> listNation() {
        return listNation;
    }

    @Override
    public List<String> listTravelInformation() {
        return listTravelInformation;
    }

    @Override
    public List<Medical> findAll() {
        return listMedical;
    }

    @Override
    public void addMedical(Medical medical) {
        listMedical.add(medical);
    }

    @Override
    public void deleteMedical(String idCard) {
        for (int i = 0; i < listMedical.size(); i++) {
            if (listMedical.get(i).getIdCard().equals(idCard)) {
                listMedical.remove(i);
                break;
            }
        }
    }

    @Override
    public Medical findByIdCard(String idCard) {
        for (int i = 0; i < listMedical.size(); i++) {
            if (listMedical.get(i).getIdCard().equals(idCard)) {
                return listMedical.get(i);
            }
        }
        return null;
    }

    @Override
    public void editMedical(Medical medical) {
        for (int i = 0; i < listMedical.size(); i++) {
            if (medical.getIdCard().equals(listMedical.get(i).getIdCard())) {
                listMedical.get(i).setName(medical.getName());
                listMedical.get(i).setBirthday(medical.getBirthday());
                listMedical.get(i).setGender(medical.getGender());
                listMedical.get(i).setNation(medical.getNation());
                listMedical.get(i).setTravelInformation(medical.getTravelInformation());
                listMedical.get(i).setVehicleId(medical.getVehicleId());
                listMedical.get(i).setSeats(medical.getSeats());
                listMedical.get(i).setStartYear(medical.getStartDay());
                listMedical.get(i).setStartMonth(medical.getStartMonth());
                listMedical.get(i).setStartDay(medical.getStartDay());
                listMedical.get(i).setEndYear(medical.getEndYear());
                listMedical.get(i).setEndMonth(medical.getEndMonth());
                listMedical.get(i).setEndDay(medical.getEndDay());
                listMedical.get(i).setGoArea(medical.getGoArea());
            }
        }
    }


    @Override
    public List<String> listYear() {
        return listYear;
    }

    @Override
    public List<String> listMonth() {
        return listMonth;
    }

    @Override
    public List<String> listDay() {
        return listDay;
    }

    @Override
    public List<String> listYearEnd() {
        return listYearEnd;
    }

    @Override
    public List<String> listMonthEnd() {
        return listMonthEnd;
    }

    @Override
    public List<String> listDayEnd() {
        return listDayEnd;
    }
}
