package com.spacefox.frida.repository;

import com.spacefox.frida.domain.Order;
import com.spacefox.frida.domain.TrampolineHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value =
            "SELECT * FROM jh_order o WHERE :eveDate = o.event_date",
            nativeQuery = true)
    List<Order> findOrdersForDate(@Param("eveDate") LocalDate eveDate);

    @Query(value =
            "SELECT * FROM jh_order o WHERE :eventDate = o.event_date AND :hallId = o.trampoline_hall_id",
            nativeQuery = true)
    List<Order> findOrdersForDateAndHall(@Param("eventDate") LocalDate eveDate,
                                         @Param("hallId") Long hallId);
}
