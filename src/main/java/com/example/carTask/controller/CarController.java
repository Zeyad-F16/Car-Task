package com.example.carTask.controller;


import com.example.carTask.models.Car;
import com.example.carTask.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/expensive")
    public Car getMostExpensive() {
        return carService.getMostExpensive();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable int id) {
        try {
            Car car = carService.getById(id);
            return ResponseEntity.ok(car);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id) {
        String message = carService.deleteCar(id);
        return ResponseEntity.ok(message);
    }


    @GetMapping("/search")
    public List<Car> filterByModelName(@RequestParam String name) {
        return carService.filterByModelName(name);
    }
}
