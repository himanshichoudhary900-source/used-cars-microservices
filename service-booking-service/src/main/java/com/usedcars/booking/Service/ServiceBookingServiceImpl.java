package com.usedcars.booking.Service;

import com.usedcars.booking.Entity.ServiceBooking;
import com.usedcars.booking.repository.ServiceBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBookingServiceImpl implements ServiceBookingService {

    private final ServiceBookingRepository bookingRepository;

    public ServiceBookingServiceImpl(ServiceBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public ServiceBooking createBooking(ServiceBooking booking) {
        // Set default status if not provided
        if (booking.getStatus() == null || booking.getStatus().isEmpty()) {
            booking.setStatus("PENDING");
        }
        return bookingRepository.save(booking);
    }

    @Override
    public List<ServiceBooking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<ServiceBooking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public ServiceBooking updateBookingStatus(Long id, String status) {
        Optional<ServiceBooking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            ServiceBooking booking = optionalBooking.get();
            booking.setStatus(status);
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found with id: " + id);
    }

    @Override
    public List<ServiceBooking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}