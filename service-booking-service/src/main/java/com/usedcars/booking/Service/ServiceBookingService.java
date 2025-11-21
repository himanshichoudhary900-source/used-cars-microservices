package com.usedcars.booking.Service;

import com.usedcars.booking.Entity.ServiceBooking;

import java.util.List;
import java.util.Optional;

public interface ServiceBookingService {
    ServiceBooking createBooking(ServiceBooking booking);
    List<ServiceBooking> getAllBookings();
    Optional<ServiceBooking> getBookingById(Long id);
    void deleteBooking(Long id);
    ServiceBooking updateBookingStatus(Long id, String status);
    List<ServiceBooking> getBookingsByUserId(Long userId);
}