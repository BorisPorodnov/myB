package com.booking.booking_mvp.service;

import com.booking.booking_mvp.booking.Room;
import com.booking.booking_mvp.booking.Status;
import com.booking.booking_mvp.entity.Booking;
import com.booking.booking_mvp.repository.BookingRepository;
import com.booking.booking_mvp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository repository;
    private final RoomRepository roomRepository;

    public Booking create(Booking booking) {
        if(booking.getRoom() != null){
            Long roomId =
                    booking.getRoom().getId();

            Room room =
                    roomRepository
                            .findById(roomId)
                            .orElseThrow();


            booking.setRoom(room);

        }
        booking.setStatus(Status.NEW);
        return repository.save(booking);

    }

    public List<Booking> findAll() {

        return repository.findAll();

    }

    public void confirm(Long id) {

        Booking booking =
                repository
                        .findById(id)
                        .orElseThrow();
        booking.setStatus(Status.CONFIRMED);
        repository.save(booking);

    }

    public void cancel(Long id) {

        Booking booking =
                repository
                        .findById(id)
                        .orElseThrow();
        booking.setStatus(Status.CANCELLED);
        repository.save(booking);

    }

}