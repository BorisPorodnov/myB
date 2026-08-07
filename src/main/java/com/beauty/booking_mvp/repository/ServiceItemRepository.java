package com.beauty.booking_mvp.repository;

import com.beauty.booking_mvp.service.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceItemRepository
        extends JpaRepository<ServiceItem,Long> {

}
