package com.spacefox.frida.repository;

import com.spacefox.frida.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

    Discount findByName(String name);

    @Query(value =
            "SELECT * FROM jh_discount AS d WHERE :availabilityDate BETWEEN d.start_availability AND d.end_availability",
            nativeQuery = true)
    List<Discount> findAvailableDiscounts(@Param("availabilityDate") LocalDate availabilityDate);
}
