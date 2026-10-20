package se.iths.qvist.webshop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TenPercentDiscountTest {
    @Test
    void shouldReturnDiscountedPrice() {
        Discount discount = new TenPercentDiscount("");
        double price = 100;

        double discountedPrice = discount.calculatePrice(price);

        Assertions.assertEquals(90.0, discountedPrice);
    }

}
