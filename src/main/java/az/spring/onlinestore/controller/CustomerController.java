package az.spring.onlinestore.controller;

import az.spring.onlinestore.dto.request.CustomerRequestDTO;
import az.spring.onlinestore.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void addCustomer(@RequestBody CustomerRequestDTO customerRequestDto){
        customerService.addCustomer(customerRequestDto);
    }
}
