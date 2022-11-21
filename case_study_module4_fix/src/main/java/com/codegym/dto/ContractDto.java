package com.codegym.dto;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContractDto implements Validator {
    private Integer id;
    private String startDate;
    private String endDate;
    private double deposit;

    @NotNull(message = "Chọn gì đó đi fren!")
    private Employee employee;
    @NotNull(message = "Chọn gì đó đi fren!")
    private Customer customer;
    @NotNull(message = "Chọn gì đó đi fren!")
    private Facility facility;
    private Double totalMoney;

    public ContractDto() {
    }

    public ContractDto(Integer id, String startDate, String endDate, double deposit, @NotBlank(message = "Chọn gì đó đi fren!") Employee employee, @NotBlank(message = "Chọn gì đó đi fren!") Customer customer, @NotBlank(message = "Chọn gì đó đi fren!") Facility facility, Double totalMoney) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.totalMoney = totalMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;

            String startDate = contractDto.getStartDate();
            Validation.checkStartDate("startDate", startDate, errors);

        String endDate = contractDto.getEndDate();
        Validation.checkEndDate("endDate", startDate, endDate, errors);

        Double deposit = contractDto.getDeposit();
        Validation.checkDouble("deposit", deposit, errors);
    }

}
