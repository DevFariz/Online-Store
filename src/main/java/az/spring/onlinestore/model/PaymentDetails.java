package az.spring.onlinestore.model;

import az.spring.onlinestore.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer orderId;

    private Double amount;

    private String provider;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;
}
