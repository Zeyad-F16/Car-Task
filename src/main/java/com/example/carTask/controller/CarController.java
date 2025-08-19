package com.example.carTask.controller;

import com.example.carTask.services.CarService;
import com.example.carTask.services.Dto.CarDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getCars(@RequestParam(required = false) String modelName) {
        List<CarDto> cars;
        if (modelName != null && !modelName.isEmpty()) {
            cars = carService.searchByModelName(modelName);
        } else {
            cars = carService.getCars();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/expensive")
    public ResponseEntity<CarDto> getMostExpensive() {
        return ResponseEntity.ok(carService.getMostExpensive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}