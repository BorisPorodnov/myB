package com.beauty.booking_mvp.repository;

import com.beauty.booking_mvp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository
        extends JpaRepository<Booking, Long> {

}