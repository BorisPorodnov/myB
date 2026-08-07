package com.beauty.booking_mvp.controller;

import com.beauty.booking_mvp.entity.Booking;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {


    @GetMapping("/")
    public String index(){

        return "index";

    }


    @GetMapping("/booking")
    public String booking(){

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