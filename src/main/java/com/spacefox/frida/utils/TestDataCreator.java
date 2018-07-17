package com.spacefox.frida.utils;

import com.spacefox.frida.domain.DTO.OrderCreateDTO;
import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.catalogs.TrampolineType;
import com.spacefox.frida.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class TestDataCreator {

    @Autowired
    private TrampolineService trampolineService;
    private Random rand = new Random();
    @Autowired
    private DiscountService discountService;
    @Autowired
    private TrampolineHallService hallService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    @Transactional
    public void createTestDiscounts(int amount){
        for(int i = 0; i < amount; i++) {
            Discount discount = Discount.builder()
                    .name("Discount_" + i)
                    .discountFactor(random(0, 50))
                    .description("some description")
                    .startAvailability(randomLocalDate(2016, 2017))
                    .endAvailability(randomLocalDate(2018, 2020))
                    .build();
            discountService.save(discount);
        }
    }

    private List<Trampoline> getTrampolines(int amount){
        List<Trampoline> list = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            Trampoline trampoline = Trampoline.builder()
                    .name("tramp_" + i)
                    .description("some desc")
                    .lastMaintenance(randomLocalDate(2000, 2015))
                    .nextMaintenance(randomLocalDate(2018, 2025))
                    .type(randomTrampolineType().orElse(TrampolineType.NORMAL))
                    .build();
            list.add(trampoline);
        }
        return list;
    }

    @Transactional
    public void createTrampolines(int amount){
        trampolineService.save(getTrampolines(amount));
    }

    @Transactional
    public void createTrampolineHalls(int amount){
        for(int i = 0; i < amount; i++){
            List<Trampoline> trampolines = getTrampolines(random(1, 20));
            trampolineService.save(trampolines);

            TrampolineHall hall = TrampolineHall.builder()
                    .name("Ogurez_" + i)
                    .phone("8-800-33-333")
                    .price(random(250, 700))
                    .address("Ubileinaia-" + i + "cb")
                    .trampolines(trampolines)
                    .build();
            trampolines.forEach(tr -> tr.setHall(hall));
            hallService.save(hall);
        }
    }

    @Transactional
    public void createOrdersForLastMonth(int amount){
        List<TrampolineHall> hallIds = hallService.getAll();
        Collections.shuffle(hallIds);
        List<Discount> discounts = discountService.getAll();
        Collections.shuffle(discounts);
        LocalDateTime bt = randomDayInLastMonth();

        OrderCreateDTO dto = OrderCreateDTO.builder()
                .hall(hallIds.get(random(0, hallIds.size())).getId())
                .employee(userService.getSU().getId())
                .discount(discounts.get(random(0, discounts.size())).getId())
                .bookingFrom(bt)
                .bookingTo(bt.plusMinutes(random(15, 180)))
                .comment(String.valueOf(random(20, 4000)))
                .customer(customerService.getCustomerStub())
    }

    private int random(int from, int to){
        return rand.nextInt((to - from)) + from;
    }

    private LocalDateTime randomDayInLastMonth(){
        return LocalDateTime.now().minusMonths(1).withDayOfMonth(random(0, 25));
    }

    private LocalDate randomLocalDate(int fromYear, int toYear){
        int year = random(fromYear, toYear);
        int month = random(1, 12);
        int day = random(1, 25);
        return LocalDate.of(year, month, day);
    }

    private Optional<TrampolineType> randomTrampolineType() {
        return Arrays.stream(TrampolineType.values()).findAny();
    }
}
