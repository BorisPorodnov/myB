package com.beauty.booking_mvp.entity;

import com.beauty.booking_mvp.booking.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "appointments")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private String phone;
    private String service;
    private LocalDate date;
    private String time;
    @Enumerated(EnumType.STRING)
    private Status status;
}