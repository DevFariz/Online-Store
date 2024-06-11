package az.spring.onlinestore.service;

import az.spring.onlinestore.dto.request.CustomerRequestDTO;
import az.spring.onlinestore.dto.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDto);

    List<CustomerResponseDTO> getAllCustomerInfo();

    void deleteCustomerInfo(Long id);

    void updateCustomerInfo(CustomerRequestDTO customerRequestDto, Long id);

    CustomerResponseDTO getCustomerInfo(Long id);
}
