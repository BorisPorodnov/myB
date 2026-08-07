package com.beauty.booking_mvp.controller;

import com.beauty.booking_mvp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final BookingService bookingService;

    @GetMapping("/admin/bookings")
    public String bookings(Model model){
        model.addAttribute(
                "bookings",
                bookingService.findAll()
        );
        return "admin/bookings";
    }


    @PostMapping("/admin/bookings/{id}/confirm")
    public String confirm(@PathVariable Long id) {
        bookingService.confirm(id);
        return "redirect:/admin/bookings";
    }


    @PostMapping("/admin/bookings/{id}/cancel")
    public String cancel(@PathVariable Long id) {
        bookingService.cancel(id);
        return "redirect:/admin/bookings";
    }
}