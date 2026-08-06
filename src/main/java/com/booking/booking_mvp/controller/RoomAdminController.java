package com.booking.booking_mvp.controller;

import com.booking.booking_mvp.booking.Room;
import com.booking.booking_mvp.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/rooms")
@RequiredArgsConstructor
public class RoomAdminController {


    private final RoomService service;



    @GetMapping
    public String rooms(Model model){

        model.addAttribute(
                "rooms",
                service.findAll()
        );

        return "admin/rooms";

    }




    @GetMapping("/new")
    public String create(Model model){

        model.addAttribute(
                "room",
                new Room()
        );

        return "admin/room-form";

    }





    @PostMapping("/save")
    public String save(
            @ModelAttribute Room room
    ){

        service.save(room);

        return "redirect:/admin/rooms";

    }





    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model
    ){

        model.addAttribute(
                "room",
                service.findById(id)
        );


        return "admin/room-form";

    }





    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ){

        service.delete(id);

        return "redirect:/admin/rooms";

    }

}