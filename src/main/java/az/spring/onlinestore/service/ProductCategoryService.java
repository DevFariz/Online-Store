package az.spring.onlinestore.service;

import az.spring.onlinestore.dto.request.ProductCategoryRequestDTO;
import az.spring.onlinestore.dto.response.ProductCategoryResponseDTO;

import java.util.List;

public interface ProductCategoryService {
    void addProductCategory(ProductCategoryRequestDTO productCategoryRequestDTO);

    List<ProductCategoryResponseDTO> getAllProductCategories();

    ProductCategoryResponseDTO getProductCategory(Long id);

    void deleteProductCategory(Long id);

    void updateProductCategory(ProductCategoryRequestDTO productCategoryRequestDTO,Long id);
}
