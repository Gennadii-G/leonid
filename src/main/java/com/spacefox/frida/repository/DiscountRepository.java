package com.spacefox.frida.repository;

import com.spacefox.frida.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

    public Discount findByName(String name);
}
