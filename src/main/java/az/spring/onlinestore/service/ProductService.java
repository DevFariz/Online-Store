package az.spring.onlinestore.service;

import az.spring.onlinestore.dto.request.ProductRequestDTO;
import az.spring.onlinestore.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    void addProduct(ProductRequestDTO productRequestDTO);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProduct(Long id);

    void deleteProduct(Long id);

    void updateProduct(ProductRequestDTO productRequestDTO, Long id);
}
