package com.booking.booking_mvp.booking;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;
    private int capacity;
    private String image;
    private boolean available;
}