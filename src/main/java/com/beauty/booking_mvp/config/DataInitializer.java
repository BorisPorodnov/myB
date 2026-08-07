package com.booking.booking_mvp.config;

import com.booking.booking_mvp.booking.Room;
import com.booking.booking_mvp.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoomRepository roomRepository;

    public DataInitializer(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }


    @Override
    public void run(String... args) {

        if(roomRepository.count() == 0){

            Room standard = new Room();

            standard.setName("🌿 Стандарт");
            standard.setDescription(
                    "Уютный номер для спокойного отдыха среди природы"
            );
            standard.setPrice(2500);
            standard.setCapacity(2);
            standard.setImage(
                    "https://images.unsplash.com/photo-1510798831971-661eb04b3739"
            );
            standard.setAvailable(true);

            Room family = new Room();

            family.setName("🌲 Семейный");
            family.setDescription(
                    "Просторный номер для семьи с красивым видом"
            );
            family.setPrice(4500);
            family.setCapacity(4);
            family.setImage(
                    "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85"
            );
            family.setAvailable(true);



            Room luxury = new Room();

            luxury.setName("🔥 Люкс с баней");
            luxury.setDescription(
                    "Премиальный номер с собственной баней"
            );
            luxury.setPrice(7000);
            luxury.setCapacity(6);
            luxury.setImage(
                    "https://images.unsplash.com/photo-1449158743715-0a90ebb6d2d8"
            );
            luxury.setAvailable(true);
            roomRepository.save(standard);
            roomRepository.save(family);
            roomRepository.save(luxury);
        }
    }
}