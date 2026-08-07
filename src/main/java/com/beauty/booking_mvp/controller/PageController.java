package com.booking.booking_mvp.controller;

import com.booking.booking_mvp.entity.Booking;
import com.booking.booking_mvp.repository.RoomRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final RoomRepository roomRepository;


    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/booking")
    public String booking(Model model){

        model.addAttribute(
                "rooms",
                roomRepository.findAll()
        );

        return "booking";
    }


    @GetMapping("/thank-you")
    public String thankYou(
            HttpSession session,
            Model model
    ){

        Booking booking =
                (Booking) session.getAttribute("booking");


        model.addAttribute(
                "booking",
                booking
        );


        return "thank-you";
    }

}