package com.usedcars.booking.Controller;

import com.usedcars.booking.Entity.ServiceBooking;
import com.usedcars.booking.Service.ServiceBookingService;
import com.usedcars.booking.dto.BookingDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class ServiceBookingController {

    private final ServiceBookingService bookingService;

    public ServiceBookingController(ServiceBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<ServiceBooking> createBooking(@Valid @RequestBody BookingDto bookingDto) {
        ServiceBooking booking = convertToEntity(bookingDto);
        ServiceBooking savedBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping
    public ResponseEntity<List<ServiceBooking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceBooking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ServiceBooking>> getBookingsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok(Map.of("message", "Booking deleted successfully"));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ServiceBooking> updateBookingStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> requestBody) {
        String newStatus = requestBody.get("status");
        ServiceBooking updatedBooking = bookingService.updateBookingStatus(id, newStatus);
        return ResponseEntity.ok(updatedBooking);
    }

    private ServiceBooking convertToEntity(BookingDto dto) {
        return ServiceBooking.builder()
                .carId(dto.getCarId())
                .userId(dto.getUserId())
                .customerName(dto.getCustomerName())
                .contactNumber(dto.getContactNumber())
                .vehicleModel(dto.getVehicleModel())
                .serviceType(dto.getServiceType())
                .bookingDate(dto.getBookingDate())
                .bookingTime(dto.getBookingTime())
                .status(dto.getStatus())
                .notes(dto.getNotes())
                .build();
    }
}