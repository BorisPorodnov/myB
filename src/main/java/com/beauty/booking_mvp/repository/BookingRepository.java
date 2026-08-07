package com.booking.booking_mvp.repository;

import com.booking.booking_mvp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository
        extends JpaRepository<Booking, Long> {

}