package com.booking.booking_mvp.controller;

import com.booking.booking_mvp.booking.Status;
import com.booking.booking_mvp.service.BookingService;
import com.booking.booking_mvp.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class AdminDashboardController {


    private final BookingService bookingService;
    private final RoomService roomService;



    @GetMapping("/admin")
    public String dashboard(Model model){


        var bookings = bookingService.findAll();


        long totalBookings =
                bookings.size();



        long newBookings =
                bookings.stream()
                        .filter(b -> b.getStatus() == Status.NEW)
                        .count();



        long finishedBookings =
                bookings.stream()
                        .filter(b ->
                                b.getStatus() == Status.CONFIRMED)
                        .count();



        long income =
                bookings.stream()
                        .filter(b ->
                                b.getStatus() == Status.CONFIRMED)
                        .mapToLong(b ->
                                b.getRoom().getPrice()
                        )
                        .sum();



        model.addAttribute(
                "bookingsCount",
                totalBookings
        );


        model.addAttribute(
                "newBookings",
                newBookings
        );


        model.addAttribute(
                "finishedBookings",
                finishedBookings
        );


        model.addAttribute(
                "income",
                income
        );


        model.addAttribute(
                "rooms",
                roomService.findAll()
        );


        return "admin/dashboard";

    }

}