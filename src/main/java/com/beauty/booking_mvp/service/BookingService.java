package com.beauty.booking_mvp.service;

import com.beauty.booking_mvp.booking.Status;
import com.beauty.booking_mvp.entity.Booking;
import com.beauty.booking_mvp.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository repository;

    public Booking create(Booking booking) {

        booking.setStatus(Status.NEW);

        return repository.save(booking);
    }


    public List<Booking> findAll() {

        return repository.findAll();

    }


    public void confirm(Long id) {

        Booking booking =
                repository.findById(id)
                        .orElseThrow();

        booking.setStatus(Status.CONFIRMED);

        repository.save(booking);

    }


    public void cancel(Long id) {

        Booking booking =
                repository.findById(id)
                        .orElseThrow();

        booking.setStatus(Status.CANCELLED);

        repository.save(booking);

    }

}