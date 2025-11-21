package com.usedcars.booking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long carId;
    private Long userId;

    private String customerName;
    private String contactNumber;

    private String vehicleModel;
    private String serviceType;
    private LocalDate bookingDate;
    private LocalTime bookingTime;

    private String status;

    @Column(length = 1000)
    private String notes;
}