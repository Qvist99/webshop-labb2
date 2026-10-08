package se.iths.qvist.webshop;

import se.iths.qvist.webshop.model.Product;

import java.util.List;

public interface ProductStorage {
    void saveProduct(Product product);

    List<Product> getProducts();

    Product getProduct(String articleNumber);
}
