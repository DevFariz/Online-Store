package az.spring.onlinestore.repository;

import az.spring.onlinestore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
