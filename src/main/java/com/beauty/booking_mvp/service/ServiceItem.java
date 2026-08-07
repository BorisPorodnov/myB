package com.beauty.booking_mvp.service;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="services")
public class ServiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String image;
}