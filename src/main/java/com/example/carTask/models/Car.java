package com.example.carTask.models;

import lombok.Data;

@Data
public class Car {
    private String thumbnail;
    private int makeId;
    private int modelId;
    private Make make;
    private Model model;
    private int year;
    private double price;
    private int carStatus;
}
