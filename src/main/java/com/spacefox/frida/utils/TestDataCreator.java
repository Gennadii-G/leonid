package com.spacefox.frida.utils;

import com.spacefox.frida.domain.*;
import com.spacefox.frida.domain.catalogs.TrampolineType;
import com.spacefox.frida.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
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
    @Autowired
    private ContactService contactService;
    @Autowired
    private OrderService orderService;

    @Transactional
    public void createDiscounts(int amount){
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

    public List<Trampoline> createTrampolines(int amount){
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
//        trampolineService.save(list);
        return list;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void createTrampolineHalls(int amount) {
        for(int i = 0; i < amount; i++){
            List<Trampoline> trampolines = createTrampolines(random(3, 20));

            TrampolineHall hall = TrampolineHall.builder()
                    .name("Ogurez_" + i)
                    .phone("8-800-33-333")
                    .price(random(250, 700))
                    .address("Ubileinaia-" + i + "cb")
                    .trampolines(trampolines)
                    .build();
            hallService.save(hall);
            trampolineService.save(trampolines);
        }
    }

    @Transactional
    public void createCustomers(int amount){
        if(contactService.contactCount() < 5){
            createContacts(10);
        }
        List<Contact> contacts = contactService.getAll();

        for(int i = 0; i < amount; i++){
            Customer customer = new Customer();
            customer.setContacts(Collections.singletonList(contacts.get(random(0, contacts.size()))));
            customer.setName("some_name" + i);
            customer.setDetails("some_details");
            customerService.save(customer);
        }
    }

    @Transactional
    public void createContacts(int amount){
        List<String> fNames = Arrays.asList("Валентин", "Марина", "Ибрагим", "Олег");
        List<String> lNames = Arrays.asList("Иванов", "Корягин", "Жигулевское", "Петрович");
        List<String> phones = Arrays.asList("32-23-23", "23-345-17", "892342144", "2144545");

        for(int i = 0; i < amount; i++) {
            Contact contact = Contact.builder()
                    .age(random(18, 40))
                    .Address("Ubileinaia-31e")
                    .firstName(fNames.get(random(0, fNames.size())))
                    .lastName(lNames.get(random(0, lNames.size())))
                    .phoneNumber(phones.get(random(0, phones.size())))
                    .build();
            contactService.save(contact);
        }
    }

    @Transactional
    public void createOrdersForLastMonth(int amount){
        if(hallService.hallsCount() < 5) {
            createTrampolineHalls(10);
        }
        if(discountService.discountCount() < 5) {
            createDiscounts(10);
        }
        if(customerService.customersCount() < 5) {
            createCustomers(10);
        }

        List<TrampolineHall> halls = hallService.getAll();
        List<Discount> discounts = discountService.getAll();
        List<Customer> customers = customerService.getAll();

        for(int i = 0; i < amount; i++) {

            LocalDateTime from = randomDayInLastMonth();
            Order order = Order.builder()
                    .hall(getRandomObj(halls))
                    .employee(userService.getSU())
                    .discount(getRandomObj(discounts))
                    .bookingFrom(from)
                    .bookingTo(from.plusMinutes(random(15, 180)))
                    .comment(String.valueOf(random(20, 4000)))
                    .customer(getRandomObj(customers))
                    .trampsAmount(random(1, 3))
                    .build();
            orderService.calculatePrice(order);
            orderService.saveWithRegDate(order);
        }
    }

    private <T> T getRandomObj(List<T> list){
       return list.get(random(0, list.size()));
    }

    private int random(int from, int to){
        return rand.nextInt((to - from)) + from;
    }

    private LocalDateTime randomDayInLastMonth(){
        return LocalDateTime.now()
                .minusMonths(1)
                .withDayOfMonth(random(1, 27))
                .withHour(random(9, 21));
    }

    private LocalDate randomLocalDate(int fromYear, int toYear){
        int year = random(fromYear, toYear);
        int month = random(1, 12);
        int day = random(1, 27);
        return LocalDate.of(year, month, day);
    }

    private Optional<TrampolineType> randomTrampolineType() {
        return Arrays.stream(TrampolineType.values()).findAny();
    }
}
