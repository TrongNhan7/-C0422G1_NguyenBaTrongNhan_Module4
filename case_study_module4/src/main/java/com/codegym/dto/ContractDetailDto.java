package com.codegym.dto;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class ContractDetailDto implements Validator {

    private int id;
    @NotNull(message = "Chọn gì đó đi fren!")
    private Contract contract;
    @NotNull(message = "Chọn gì đó đi fren!")
    private AttachFacility attachFacility;

    private int quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(int id, @NotNull(message = "Chọn gì đó đi fren!") Contract contract, @NotNull(message = "Chọn gì đó đi fren!") AttachFacility attachFacility, int quantity) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDetailDto = (ContractDetailDto) target;

        String quantity = String.valueOf(contractDetailDto.quantity);
        Validation.checkInteger("quantity", quantity, errors);
    }
}
