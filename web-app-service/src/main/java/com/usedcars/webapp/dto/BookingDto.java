package com.usedcars.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private Long carId;
    private Long userId;
    private String serviceType;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private String status;
    private String notes;
    private String customerName;
    private String contactNumber;
    private String vehicleModel;

    // Constructor for mock data (backward compatible)
    public BookingDto(Long id, Long userId, Long carId, String serviceType,
                      LocalDateTime bookingDateTime, String status, String notes,
                      String customerName, String contactNumber, String vehicleModel) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.serviceType = serviceType;
        if (bookingDateTime != null) {
            this.bookingDate = bookingDateTime.toLocalDate();
            this.bookingTime = bookingDateTime.toLocalTime();
        }
        this.status = status;
        this.notes = notes;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.vehicleModel = vehicleModel;
    }
}