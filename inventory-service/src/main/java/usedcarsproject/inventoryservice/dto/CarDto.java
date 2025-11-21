package usedcarsproject.inventoryservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.*;
import lombok.*;
import usedcarsproject.inventoryservice.config.MultiFormatLocalDateDeserializer;
import usedcarsproject.inventoryservice.util.CarStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarDto {
    @Positive
    private Long id;


    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @Min(value = 1886, message = "Year must be 1886 or later")
    @Max(value = 2030, message = "Year cannot be in the far future")
    private Integer year;

    @PositiveOrZero(message = "Mileage must be zero or positive")
    private Integer mileage;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @PastOrPresent(message = "Date listed cannot be in the future")
    @JsonDeserialize(using = MultiFormatLocalDateDeserializer.class)
    private LocalDate dateListed;

    @NotNull(message = "Car status is required")
    private CarStatus carStatus;

    @Size(max = 50, message = "Color name too long")
    private String color;

    @Pattern(regexp = "Manual|Automatic|Semi-Automatic|CVT",
            message = "Transmission must be Manual, Automatic, Semi-Automatic, or CVT")
    private String transmission;

    @Pattern(regexp = "Petrol|Diesel|Electric|Hybrid|CNG",
            message = "Fuel type must be Petrol, Diesel, Electric, Hybrid, or CNG")
    private String fuelType;

    @Size(max = 500, message = "Image URL too long")
    private String imageUrl;
}