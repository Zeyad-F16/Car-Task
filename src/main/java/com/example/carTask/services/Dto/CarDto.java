package com.example.carTask.services.Dto;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class CarDto {

    private String thumbnail;
    private long makeID;
    private long modelID;
    @JsonAlias("make")
    private Details makerDetails;
    private Details model;
    private long year;
    private long price;
    private long carStatus;
}