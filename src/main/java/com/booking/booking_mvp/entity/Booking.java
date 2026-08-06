package com.booking.booking_mvp.entity;

import com.booking.booking_mvp.booking.Room;
import com.booking.booking_mvp.booking.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private String phone;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}