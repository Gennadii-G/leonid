package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.CustomerDTO;
import com.spacefox.frida.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @DeleteMapping("/customer/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(CustomerDTO dto){
        customerService.delete(customerService.convert(dto));
    }

    @DeleteMapping("/customer/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }

    @GetMapping("/customers")
    public List<CustomerDTO> allCustomers() {
        return customerService.convert(customerService.getAll());
    }

    @PostMapping("/customer/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@RequestBody @Valid CustomerDTO dto) {
        customerService.save(customerService.convert(dto));
    }

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO customerById(@PathVariable Long id) {
        return customerService.convert(customerService.getById(id));
    }

    @PutMapping("/customer/update/")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@RequestBody @Valid CustomerDTO dto) {
        customerService.update(customerService.convert(dto));
    }
}
