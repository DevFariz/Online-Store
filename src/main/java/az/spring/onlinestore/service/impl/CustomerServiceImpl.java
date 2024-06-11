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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final CustomerAddressRepository customerAddressRepository;
    private final CustomerPaymentRepository customerPaymentRepository;

    @Transactional
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

    @Override
    public List<CustomerResponseDTO> getAllCustomerInfo() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOList = customers.stream()
                .map(this::modelToDtoConverter)
                .collect(Collectors.toList());

        return customerResponseDTOList;
    }

    @Override
    public CustomerResponseDTO getCustomerInfo(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

       return modelToDtoConverter(customer);
    }

    @Transactional
    @Override
    public void deleteCustomerInfo(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        customerAddressRepository.deleteById(customer.getCustomerAddress().getId());
        customerPaymentRepository.deleteById(customer.getCustomerPayment().getId());

        customerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateCustomerInfo(CustomerRequestDTO customerRequestDto, Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        CustomerAddress customerAddress = customerAddressRepository.findById(customer.getCustomerAddress().getId()).orElseThrow(() -> new RuntimeException("Customer Address not found"));
        CustomerPayment customerPayment = customerPaymentRepository.findById(customer.getCustomerAddress().getId()).orElseThrow(() -> new RuntimeException("Customer Payment not found"));


        modelMapper.map(customerRequestDto, customerAddress);
        modelMapper.map(customerRequestDto, customerPayment);
        modelMapper.map(customerRequestDto, customer);

        customerAddressRepository.save(customerAddress);
        customerPaymentRepository.save(customerPayment);
        customerRepository.save(customer);
    }

    private CustomerResponseDTO modelToDtoConverter(Customer customer){
        CustomerResponseDTO dto = modelMapper.map(customer, CustomerResponseDTO.class);
        dto.setId(customer.getId());

        CustomerAddress customerAddress = customerAddressRepository.findByCustomerId(customer.getId());
        if (customerAddress != null) {
            modelMapper.map(customerAddress, dto);
        }

        CustomerPayment customerPayment = customerPaymentRepository.findByCustomerId(customer.getId());
        if (customerPayment != null) {
            modelMapper.map(customerPayment, dto);
        }

        return dto;
    }
}
