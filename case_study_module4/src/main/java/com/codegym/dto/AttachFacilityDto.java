package com.codegym.dto;

import com.codegym.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class AttachFacilityDto implements Validator {

    private Integer id;
    @NotBlank(message = "Điền chi đó vào đi!")
    private String name;
    private Double cost;
    private String unit;
    @NotBlank(message = "Điền chi đó vào đi!")
    private String status;

    public AttachFacilityDto() {
    }

    public AttachFacilityDto(Integer id, @NotBlank(message = "Điền chi đó vào đi!") String name, Double cost, String unit, @NotBlank(message = "Điền chi đó vào đi!") String status) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AttachFacilityDto attachFacilityDto = (AttachFacilityDto) target;

        Double cost = attachFacilityDto.getCost();
        Validation.checkDouble("cost", cost, errors);
    }
}
