package com.beauty.booking_mvp.controller;

import com.beauty.booking_mvp.entity.Booking;
import com.beauty.booking_mvp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class AdminCalendarController {


    private final BookingService bookingService;



    @GetMapping("/admin/calendar")
    public String calendar(Model model){


        LocalDate now = LocalDate.now();



        List<Booking> bookings =

                bookingService.findAll()

                        .stream()

                        .filter(b -> b.getDate() != null)

                        .sorted(
                                (a,b) ->
                                        a.getTime()
                                                .compareTo(b.getTime())
                        )

                        .toList();




        /*
         * Все записи по дням
         *
         * 7 августа:
         * 10:00 Анна
         * 12:30 Мария
         *
         */

        Map<Integer, List<Booking>> bookingsByDay =


                bookings.stream()

                        .collect(Collectors.groupingBy(

                                b -> b.getDate()
                                        .getDayOfMonth()

                        ));





        /*
         * Нужно для подсветки занятых дней
         */

        Map<Integer, Long> calendar =


                bookings.stream()

                        .collect(Collectors.groupingBy(

                                b -> b.getDate()
                                        .getDayOfMonth(),

                                Collectors.counting()

                        ));





        model.addAttribute(
                "bookings",
                bookings
        );



        model.addAttribute(
                "bookingsByDay",
                bookingsByDay
        );



        model.addAttribute(
                "calendar",
                calendar
        );



        model.addAttribute(
                "days",

                IntStream.rangeClosed(
                                1,
                                now.lengthOfMonth()
                        )

                        .boxed()

                        .toList()

        );



        model.addAttribute(
                "monthName",

                now.getMonth()
                        .getDisplayName(
                                TextStyle.FULL,
                                new Locale("ru")
                        )

        );



        model.addAttribute(
                "month",
                now.getMonthValue()
        );



        model.addAttribute(
                "year",
                now.getYear()
        );



        return "admin/calendar";

    }

}