package az.spring.onlinestore.controller;

import az.spring.onlinestore.dto.request.ProductRequestDTO;
import az.spring.onlinestore.dto.response.ProductResponseDTO;
import az.spring.onlinestore.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void addProduct(ProductRequestDTO productRequestDTO){
        productService.addProduct(productRequestDTO);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody ProductRequestDTO productRequestDTO, Long id){
        productService.updateProduct(productRequestDTO, id);
    }
}
