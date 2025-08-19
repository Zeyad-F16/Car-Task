package com.example.carTask.services;

import com.example.carTask.services.Dto.CarDto;
import java.util.List;

public interface CarService {
    List<CarDto> getCars();
    CarDto getMostExpensive();
    CarDto getCarById(long id);
    void addCar(CarDto car);
    void deleteCar(long id);
    List<CarDto> searchByModelName(String modelName);
}