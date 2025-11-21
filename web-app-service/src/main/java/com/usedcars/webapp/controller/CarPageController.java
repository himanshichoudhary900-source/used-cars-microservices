package com.usedcars.webapp.controller;

import com.usedcars.webapp.dto.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarPageController {

    @Autowired
    private WebClient inventoryWebClient;

    @GetMapping
    public String listCars(Model model) {
        List<CarDto> cars = getMockCars();
        
        model.addAttribute("title", "Available Cars");
        model.addAttribute("cars", cars);
        return "cars/list";
    }

    @GetMapping("/{id}")
    public String carDetails(@PathVariable Long id, Model model) {
        CarDto car = getMockCarById(id);
        
        model.addAttribute("title", "Car Details");
        model.addAttribute("car", car);
        return "cars/details";
    }

    @GetMapping("/form")
    public String carForm(@RequestParam(required = false) Long id, Model model) {
        CarDto car = (id != null) ? getMockCarById(id) : new CarDto();
        
        model.addAttribute("title", id != null ? "Edit Car" : "Add New Car");
        model.addAttribute("car", car);
        return "cars/form";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute CarDto carDto, Model model) {
        System.out.println("Saving car: " + carDto);
        
        return "redirect:/cars";
    }

    private List<CarDto> getMockCars() {
        List<CarDto> cars = new ArrayList<>();
        
        cars.add(new CarDto(1L, "Toyota", "Camry", 2020, 25000.0, "Silver", 
                           30000, "Petrol", "Automatic", "AVAILABLE", 
                           "Well maintained sedan", "/images/car1.jpg"));
        
        cars.add(new CarDto(2L, "Honda", "Civic", 2019, 22000.0, "Black", 
                           45000, "Petrol", "Manual", "AVAILABLE", 
                           "Sporty and efficient", "/images/car2.jpg"));
        
        cars.add(new CarDto(3L, "Ford", "Mustang", 2021, 35000.0, "Red", 
                           15000, "Petrol", "Automatic", "AVAILABLE", 
                           "Powerful sports car", "/images/car3.jpg"));
        
        cars.add(new CarDto(4L, "Tesla", "Model 3", 2022, 45000.0, "White", 
                           8000, "Electric", "Automatic", "SOLD", 
                           "Electric luxury sedan", "/images/car4.jpg"));
        
        return cars;
    }
    
    private CarDto getMockCarById(Long id) {
        return getMockCars().stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElse(new CarDto());
    }

    /*
    private List<CarDto> fetchCarsFromAPI() {
        return inventoryWebClient.get()
                .uri("/api/cars")
                .retrieve()
                .bodyToFlux(CarDto.class)
                .collectList()
                .block();
    }
    
    private CarDto fetchCarByIdFromAPI(Long id) {
        return inventoryWebClient.get()
                .uri("/api/cars/" + id)
                .retrieve()
                .bodyToMono(CarDto.class)
                .block();
    }
    
    private void saveCarToAPI(CarDto carDto) {
        inventoryWebClient.post()
                .uri("/api/cars")
                .body(Mono.just(carDto), CarDto.class)
                .retrieve()
                .bodyToMono(CarDto.class)
                .block();
    }
    */
    
}