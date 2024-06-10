package az.spring.onlinestore.repository;

import az.spring.onlinestore.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
