package com.booking.booking_mvp.service;

import com.booking.booking_mvp.booking.Room;
import com.booking.booking_mvp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository repository;


    public List<Room> findAll(){
        return repository.findAll();
    }


    public Room findById(Long id){

        return repository
                .findById(id)
                .orElseThrow();

    }


    public void save(Room room){

        repository.save(room);

    }


    public void delete(Long id){

        repository.deleteById(id);

    }

}
