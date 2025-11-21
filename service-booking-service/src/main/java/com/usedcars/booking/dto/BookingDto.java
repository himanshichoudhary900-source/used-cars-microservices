package com.usedcars.booking.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingDto {
    private Long id;

    @NotNull(message = "Car ID is required")
    private Long carId;

    private Long userId;

    @NotBlank(message = "Customer name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String customerName;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Invalid contact number")
    private String contactNumber;

    @Size(max = 100, message = "Vehicle model name too long")
    private String vehicleModel;

    @NotBlank(message = "Service type is required")
    @Pattern(regexp = "OIL_CHANGE|TIRE_ROTATION|BRAKE_SERVICE|ENGINE_CHECKUP|GENERAL_SERVICE|MAINTENANCE|INSPECTION",
            message = "Invalid service type")
    private String serviceType;

    @NotNull(message = "Booking date is required")
    @Future(message = "Booking date must be in the future")
    private LocalDate bookingDate;

    @NotNull(message = "Booking time is required")
    private LocalTime bookingTime;

    @Pattern(regexp = "PENDING|CONFIRMED|COMPLETED|CANCELLED",
            message = "Invalid status")
    private String status;

    @Size(max = 1000, message = "Notes cannot exceed 1000 characters")
    private String notes;
}