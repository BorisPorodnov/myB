package com.booking.booking_mvp.controller;


import com.booking.booking_mvp.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RoomController {
    private final RoomRepository roomRepository;
    public RoomController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public String rooms(Model model){
        model.addAttribute(
                "rooms",
                roomRepository.findAll()
        );
        return "rooms";

    }

}