package com.codegym.dto;

import com.codegym.model.Customer;
import com.codegym.model.TypeService;
import com.codegym.util.ValidateExam;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class TradeDto implements Validator {

    private String id;

    private String startDate;
    @NotBlank(message = "Nhập vào đi bạn ơi!")
    private TypeService typeService;

    private Double cost;
    private Double area;

    private Customer customer;

    public TradeDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TradeDto tradeDto = (TradeDto) target;

        String name = tradeDto.getId();
        if (!name.matches("^(MGD)-[0-9]{4}$")) {
            errors.rejectValue("name", "customerName.create", "Nhập theo định dạng MGD-XXXX");
        }

        Double cost = tradeDto.getCost();
        ValidateExam.checkDouble("cost", cost, errors);

        String startDate = tradeDto.getStartDate();
        ValidateExam.checkStartDate("startDate", startDate, errors);

        Double area = tradeDto.getArea();
        ValidateExam.checkDouble("area", cost, errors);
    }
}
