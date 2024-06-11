package az.spring.onlinestore.service;

import az.spring.onlinestore.dto.request.CustomerRequestDTO;
import az.spring.onlinestore.dto.response.CustomerResponseDTO;

public interface CustomerService {
    CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDto);
}
