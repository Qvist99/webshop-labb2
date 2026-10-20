package se.iths.qvist.webshop.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HalfPriceDiscountTest {
    @Test
    void shouldReturnDiscountedPrice() {
        Discount discount = new HalfPriceDiscount("");
        double price = 100;

        double discountedPrice = discount.calculatePrice(price);

        Assertions.assertEquals(50.0, discountedPrice);
    }
}
