package az.spring.onlinestore.dto.request;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String name;

    private String description;

    private Double price;
}
