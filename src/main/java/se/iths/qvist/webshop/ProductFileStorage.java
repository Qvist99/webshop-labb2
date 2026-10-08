package se.iths.qvist.webshop;

import se.iths.qvist.webshop.model.Product;

import java.nio.file.Path;
import java.util.List;

public class ProductFileStorage implements ProductStorage {
    //Might swap to JSON later
    private Path file = Path.of("products.txt");


    public void saveProduct(Product product) {
        //Write to product to new line in file.
    }

    public List<Product> getProducts() {
        // Create empty list

        //Check if file exists. If not return empty list.

        //Read all lines from the file

        // loop over all lines and add to list and return

        return null;
    }

    public Product getProduct(String articleNumber) {
        // Get all products


        //Loop through until we find product with given articleNumber and return
        //If we decide to have a JSON file we could instead just make a lookup against the article number to get the product.

        return null;
    }

}
