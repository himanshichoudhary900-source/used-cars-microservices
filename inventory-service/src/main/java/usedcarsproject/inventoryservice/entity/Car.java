package usedcarsproject.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import usedcarsproject.inventoryservice.util.CarStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Changed from 'make' to 'brand' to match templates
    private String brand;

    private String model;

    @Column(name = "car_year")
    private Integer year;

    private Integer mileage;

    private BigDecimal price;

    private String description;

    private LocalDate dateListed;

    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;

    private String color;

    private String transmission;

    private String fuelType;

    private String imageUrl;
}