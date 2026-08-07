package com.beauty.booking_mvp.config;

import com.beauty.booking_mvp.service.ServiceItem;
import com.beauty.booking_mvp.repository.ServiceItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ServiceItemRepository repository;

    public DataInitializer(ServiceItemRepository repository){
        this.repository=repository;
    }

    @Override
    public void run(String... args){

        if(repository.count()==0){

            ServiceItem manicure=new ServiceItem();
            manicure.setName("💅 Маникюр");
            manicure.setDescription(
                    "Аккуратная обработка ногтей и уход за руками"
            );
            manicure.setPrice(1200);
            manicure.setImage(
                    "https://images.unsplash.com/photo-1604654894610-df63bc536371"
            );


            ServiceItem pedicure=new ServiceItem();
            pedicure.setName("🦶 Педикюр");
            pedicure.setDescription(
                    "Уход за стопами и красивое покрытие ногтей"
            );
            pedicure.setPrice(1800);
            pedicure.setImage(
                    "https://images.unsplash.com/photo-1519014816548-bf5fe059798b"
            );


            ServiceItem coating=new ServiceItem();
            coating.setName("✨ Маникюр + покрытие");
            coating.setDescription(
                    "Гель-лак, ровное покрытие и красивый дизайн"
            );
            coating.setPrice(2000);
            coating.setImage(
                    "https://images.unsplash.com/photo-1610992015732-2449b76344bc"
            );


            ServiceItem design=new ServiceItem();
            design.setName("🎨 Дизайн ногтей");
            design.setDescription(
                    "Авторский дизайн, рисунки и декор"
            );
            design.setPrice(500);
            design.setImage(
                    "https://images.unsplash.com/photo-1607779097040-26e80aa78e66"
            );


            ServiceItem strengthening=new ServiceItem();
            strengthening.setName("💎 Укрепление ногтей");
            strengthening.setDescription(
                    "Укрепление базой и восстановление ногтей"
            );
            strengthening.setPrice(1500);
            strengthening.setImage(
                    "https://images.unsplash.com/photo-1610992015732-2449b76344bc"
            );

            repository.save(manicure);
            repository.save(pedicure);
            repository.save(coating);
            repository.save(design);
            repository.save(strengthening);
        }
    }
}