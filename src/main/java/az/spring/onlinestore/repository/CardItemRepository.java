package az.spring.onlinestore.repository;

import az.spring.onlinestore.model.CardItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardItemRepository extends JpaRepository<CardItem, Long> {
}
