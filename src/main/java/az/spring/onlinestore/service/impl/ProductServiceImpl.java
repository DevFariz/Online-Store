package az.spring.onlinestore.service.impl;

import az.spring.onlinestore.dto.request.ProductRequestDTO;
import az.spring.onlinestore.dto.response.ProductResponseDTO;
import az.spring.onlinestore.model.Product;
import az.spring.onlinestore.repository.ProductRepository;
import az.spring.onlinestore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    @Override
    public void addProduct(ProductRequestDTO productRequestDTO) {
        Product product = modelMapper.map(productRequestDTO, Product.class);

        productRepository.save(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> productResponseDTOS = productRepository
                .findAll()
                .stream().map(product -> {
                    ProductResponseDTO productResponseDTO = modelMapper.map(product, ProductResponseDTO.class);
                    productResponseDTO.setId(product.getId());

                    return productResponseDTO;
                })
                .collect(Collectors.toList());


        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product was not found"));

        return modelMapper.map(product, ProductResponseDTO.class);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(ProductRequestDTO productRequestDTO, Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product was not found"));

        modelMapper.map(productRequestDTO, product);

        productRepository.save(product);
    }
}
