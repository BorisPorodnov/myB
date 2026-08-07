package com.beauty.booking_mvp.controller;

import com.beauty.booking_mvp.booking.Status;
import com.beauty.booking_mvp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class AdminDashboardController {


    private final BookingService bookingService;



    @GetMapping("/admin")
    public String dashboard(Model model){


        var bookings =
                bookingService.findAll();

        long totalBookings =
                bookings.size();

        long newBookings =
                bookings.stream()
                        .filter(b ->
                                b.getStatus()
                                        == Status.NEW)
                        .count();

        long confirmedBookings =
                bookings.stream()
                        .filter(b ->
                                b.getStatus()
                                        == Status.CONFIRMED)
                        .count();

        long todayBookings =
                bookings.stream()
                        .filter(b ->
                                b.getDate()
                                        .equals(LocalDate.now()))
                        .count();

        model.addAttribute(
                "bookingsCount",
                totalBookings
        );

        model.addAttribute(
                "newBookings",
                newBookings
        );

        model.addAttribute(
                "confirmedBookings",
                confirmedBookings
        );

        model.addAttribute(
                "todayBookings",
                todayBookings
        );
        return "admin/dashboard";

    }

}