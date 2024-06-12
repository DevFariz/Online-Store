package az.spring.onlinestore.service.impl;

import az.spring.onlinestore.dto.request.ProductCategoryRequestDTO;
import az.spring.onlinestore.dto.response.ProductCategoryResponseDTO;
import az.spring.onlinestore.model.ProductCategory;
import az.spring.onlinestore.repository.ProductCategoryRepository;
import az.spring.onlinestore.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ModelMapper modelMapper;
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public void addProductCategory(ProductCategoryRequestDTO productCategoryRequestDTO) {

        ProductCategory productCategory = modelMapper.map(productCategoryRequestDTO, ProductCategory.class);

        productCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategoryResponseDTO> getAllProductCategories() {

        List<ProductCategoryResponseDTO> productCategoryResponseDTOS = productCategoryRepository
                .findAll()
                .stream()
                .map(productCategory -> {
                    ProductCategoryResponseDTO productCategoryResponseDTO = modelMapper.map(productCategory, ProductCategoryResponseDTO.class);
                    productCategoryResponseDTO.setId(productCategory.getId());
                    return productCategoryResponseDTO;
                }).collect(Collectors.toList());

        return productCategoryResponseDTOS;
    }

    @Override
    public ProductCategoryResponseDTO getProductCategory(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Category not found"));

        return modelMapper.map(productCategory, ProductCategoryResponseDTO.class);
    }

    @Override
    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }

    @Override
    public void updateProductCategory(ProductCategoryRequestDTO productCategoryRequestDTO, Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Category not found"));

        modelMapper.map(productCategoryRequestDTO, productCategory);

        productCategoryRepository.save(productCategory);
    }
}
