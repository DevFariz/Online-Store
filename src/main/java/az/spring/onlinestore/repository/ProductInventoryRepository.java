package az.spring.onlinestore.repository;

import az.spring.onlinestore.model.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {
}
