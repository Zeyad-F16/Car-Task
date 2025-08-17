package com.example.carTask.controller;


import com.example.carTask.models.Car;
import com.example.carTask.services.CarService;
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
    public Car getById(@PathVariable int id) {
        return carService.getById(id).orElse(null);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        carService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Car> filterByModelName(@RequestParam String name) {
        return carService.filterByModelName(name);
    }
}
