package se.iths.qvist.webshop;

import se.iths.qvist.webshop.model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ProductFileStorage implements ProductStorage {
    private final Path file = Path.of("products.txt");


    public void saveProduct(Product product) {
        //Write to product to new line in file.
        try {

            if (Files.notExists(file)) {
                Files.createFile(file);
            }
        } catch (IOException e) {
            System.err.println("Could not create file: " + e.getMessage());
        }


        try {
            Files.writeString(file, product.toFileLine() + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Could not write product to file");
        }
    }

    public List<Product> getProducts() {
        if (Files.notExists(file)) {
            return List.of();
        }

        try {
            return Files.readAllLines(file)
                    .stream()
                    .filter(line -> !line.isBlank())
                    .map(Product::fromFileLine)
                    .toList();
        } catch (IOException e) {
            System.err.println("Could not read products from file: " + e.getMessage());
            return List.of();
        }
    }

    public Product getProduct(String articleNumber) {
        // Get all products
        List<Product> products = getProducts();

        //Loop through until we find product with given articleNumber and return

        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNumber)) {
                return product;
            }
        }

        return null;
    }

}
