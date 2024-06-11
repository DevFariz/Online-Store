package az.spring.onlinestore.service.impl;

import az.spring.onlinestore.dto.request.CustomerRequestDTO;
import az.spring.onlinestore.dto.response.CustomerResponseDTO;
import az.spring.onlinestore.model.Customer;
import az.spring.onlinestore.model.CustomerAddress;
import az.spring.onlinestore.model.CustomerPayment;
import az.spring.onlinestore.repository.CustomerAddressRepository;
import az.spring.onlinestore.repository.CustomerPaymentRepository;
import az.spring.onlinestore.repository.CustomerRepository;
import az.spring.onlinestore.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final CustomerAddressRepository customerAddressRepository;
    private final CustomerPaymentRepository customerPaymentRepository;

    @Override
    public CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDto) {

        CustomerAddress customerAddress = modelMapper.map(customerRequestDto, CustomerAddress.class);
        CustomerPayment customerPayment = modelMapper.map(customerRequestDto, CustomerPayment.class);
        Customer customer = modelMapper.map(customerRequestDto, Customer.class);

        customer.setCustomerPayment(customerPayment);
        customer.setCustomerAddress(customerAddress);

        customerAddressRepository.save(customerAddress);
        customerPaymentRepository.save(customerPayment);
        customerRepository.save(customer);

        CustomerResponseDTO customerResponseDTO = modelMapper.map(customer, CustomerResponseDTO.class);
        customerResponseDTO.setId(customer.getId());

        return customerResponseDTO;
    }


}
