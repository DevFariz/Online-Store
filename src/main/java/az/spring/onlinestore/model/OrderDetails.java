package az.spring.onlinestore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total;

    @OneToOne
    @JoinColumn(name = "payment_details_id")
    private PaymentDetails paymentDetails;

    @OneToMany
    @JoinColumn(name = "order_details_id")
    private List<CardItem> cardItem;
}
