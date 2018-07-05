package com.spacefox.frida.services.converter;

import com.spacefox.frida.domain.DTO.DiscountDTO;
import com.spacefox.frida.domain.Discount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class DiscountToDiscountDTO implements Converter<Discount, DiscountDTO> {

    @Override
    public DiscountDTO convert(Discount source) {
        return DiscountDTO.builder()
                .id(source.getId())
                .description(source.getDescription())
                .name(source.getName())
                .discountFactor(source.getDiscountFactor())
                .build();
    }

    public Discount convert(DiscountDTO source) {
        return Discount.builder()
                .id(source.getId())
                .description(source.getDescription())
                .name(source.getName())
                .discountFactor(source.getDiscountFactor())
                .build();
    }
}
