package se.iths.qvist.webshop;

import se.iths.qvist.webshop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductListStorage implements ProductStorage {
    Map<String, Product> products = new HashMap<>();

    public void saveProduct(Product product) {
        products.put(product.getArticleNumber(), product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProduct(String articleNumber) {
        return products.get(articleNumber);
    }
}
