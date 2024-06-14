package az.spring.onlinestore.controller;

import az.spring.onlinestore.dto.request.CustomerRequestDTO;
import az.spring.onlinestore.dto.response.CustomerResponseDTO;
import az.spring.onlinestore.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void addCustomer(@RequestBody CustomerRequestDTO customerRequestDto){
        customerService.addCustomer(customerRequestDto);
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomerInfo(){
        return customerService.getAllCustomerInfo();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerInfo(@PathVariable Long id){
        return customerService.getCustomerInfo(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerInfo(@PathVariable Long id){
        customerService.deleteCustomerInfo(id);
    }

    @PutMapping("/{id}")
    public void updateCustomerInfo(@RequestBody CustomerRequestDTO customerRequestDto, @PathVariable Long id){
        customerService.updateCustomerInfo(customerRequestDto, id);
    }

}
