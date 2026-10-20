package se.iths.qvist.webshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.iths.qvist.webshop.model.Product;

import java.util.List;

public class WebShopManagerTest {
    private WebShopManager webShopManager;

    @BeforeEach
    void setUp() {
        ProductStorage storage = new ProductListStorage();
        OutInputHandler handler = new ConsoleOutInputHandler();
        webShopManager = new WebShopManager(storage, handler);
    }

    @Test
    @DisplayName("Checks if the productStorage returns correct amount of products")
    void getProductsFromStorageReturnsTwoProducts() {
        Product product1 = new Product("1", "Product 1", 10, "Description");
        Product product2 = new Product("2", "Product 2", 20, "Description");

        webShopManager.saveProductToStorage(product1);
        webShopManager.saveProductToStorage(product2);

        List<Product> products = webShopManager.getProductsFromStorage();

        Assertions.assertEquals(2, products.size());
    }

    @Test
    void getSpecificProductFromStorage() {
        Product product1 = new Product("1", "Product 1", 10, "Description");

        webShopManager.saveProductToStorage(product1);

        Product savedProduct = webShopManager.getProductFromStorage("1");

        Assertions.assertEquals("1", savedProduct.getArticleNumber());
    }

    @Test
    void productMissingReturnsNull() {
        Product product = webShopManager.getProductFromStorage("4123");
        
        Assertions.assertNull(product);
    }
}
