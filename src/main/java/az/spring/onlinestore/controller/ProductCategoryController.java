package az.spring.onlinestore.controller;

import az.spring.onlinestore.dto.request.ProductCategoryRequestDTO;
import az.spring.onlinestore.dto.response.ProductCategoryResponseDTO;
import az.spring.onlinestore.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("product-categories")
@RestController
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @PostMapping
    public void addProductCategory(@RequestBody ProductCategoryRequestDTO productCategoryRequestDTO){
        productCategoryService.addProductCategory(productCategoryRequestDTO);
    }

    @GetMapping
    public List<ProductCategoryResponseDTO> getAllProductCategories(){
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping("/{id}")
    public ProductCategoryResponseDTO getProductCategory(@PathVariable Long id){
        return productCategoryService.getProductCategory(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductCategory(@PathVariable Long id){
        productCategoryService.deleteProductCategory(id);
    }

    @PutMapping("/{id}")
    public void updateProductCategory(@RequestBody ProductCategoryRequestDTO productCategoryRequestDTO, Long id){
        productCategoryService.updateProductCategory(productCategoryRequestDTO, id);
    }

}
