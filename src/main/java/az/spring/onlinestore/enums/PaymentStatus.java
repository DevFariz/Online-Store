package az.spring.onlinestore.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
    SUCCESS(1),
    PENDING(2),
    FAILED(3);

    private final Integer value;



}
