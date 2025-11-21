package com.usedcars.booking.repository;

import com.usedcars.booking.Entity.ServiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long> {
    List<ServiceBooking> findByUserId(Long userId);
    List<ServiceBooking> findByStatus(String status);
}