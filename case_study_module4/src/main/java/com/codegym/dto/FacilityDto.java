package com.codegym.dto;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import com.codegym.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class FacilityDto implements Validator {

    private Integer id;
    private String nameService;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double areaPool;
    private Integer numberOfFloors;
    private String freeService;
    private RentType rentType;

    private FacilityType facilityType;

    public FacilityDto() {
    }

    public FacilityDto(Integer id, @NotBlank(message = "Nhập vào đi bạn ơi!") String nameService, Integer area, Double cost, Integer maxPeople, String standardRoom, String descriptionOtherConvenience, Double areaPool, Integer numberOfFloors, String freeService, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.nameService = nameService;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
        this.freeService = freeService;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(Double areaPool) {
        this.areaPool = areaPool;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;

        String maxPeople = String.valueOf(facilityDto.getMaxPeople());
        Validation.checkInteger("maxPeople", maxPeople, errors);

        String area = String.valueOf((facilityDto.getArea()));
        Validation.checkInteger("area", area, errors);

        Double cost = facilityDto.getCost();
        Validation.checkDouble("cost", cost, errors);

        String nameService = facilityDto.getNameService();
        Validation.checkFacilityName("nameService", nameService, errors);

        if (facilityDto.getFacilityType() != null) {
            Integer facilityTypeId = facilityDto.getFacilityType().getId();
            if (facilityTypeId < 2) {
                Double areaPool = facilityDto.getAreaPool();
                Validation.checkDouble("areaPool", areaPool, errors);
            }
            if (facilityTypeId < 3) {
                String numberOfFloors = String.valueOf((facilityDto.getNumberOfFloors()));
                Validation.checkInteger("numberOfFloors", numberOfFloors, errors);
            }
        }
    }

}
