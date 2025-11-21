package com.usedcars.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private BigDecimal price;
    private String color;
    private Integer mileage;
    private String fuelType;
    private String transmission;
    private String carStatus;
    private String description;
    private String imageUrl;

    // Constructor for mock data (backward compatible)
    public CarDto(Long id, String brand, String model, Integer year, Double price,
                  String color, Integer mileage, String fuelType, String transmission,
                  String carStatus, String description, String imageUrl) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = BigDecimal.valueOf(price);
        this.color = color;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.carStatus = carStatus;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}