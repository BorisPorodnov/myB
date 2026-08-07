package com.beauty.booking_mvp.controller;

import com.beauty.booking_mvp.entity.Booking;
import com.beauty.booking_mvp.service.BookingService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService service;
    @PostMapping
    public Booking create(
            @RequestBody Booking booking,
            HttpSession session
    ){
        Booking saved = service.create(booking);
        session.setAttribute(
                "booking",
                saved
        );
        return saved;
    }
}