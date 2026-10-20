package se.iths.qvist.webshop;

import se.iths.qvist.webshop.model.Discount;
import se.iths.qvist.webshop.model.HalfPriceDiscount;
import se.iths.qvist.webshop.model.Product;
import se.iths.qvist.webshop.model.TenPercentDiscount;

import java.util.List;

public class WebShopManager {
    private final ProductStorage productStorage;
    private final OutInputHandler outInputHandler;

    public WebShopManager(ProductStorage productStorage, OutInputHandler outInputHandler) {
        this.productStorage = productStorage;
        this.outInputHandler = outInputHandler;
    }

    public void saveProductToStorage(Product product) {
        productStorage.saveProduct(product);
    }

    public List<Product> getProductsFromStorage() {
        return productStorage.getProducts();
    }

    public Product getProductFromStorage(String articleNumber) {
        return productStorage.getProduct(articleNumber);
    }

    public void startWebshop() {
        boolean keepRunning = true;
        String userDiscountChoice = outInputHandler.prompt("Enter your discount code: ");
        Discount discount;

        if (userDiscountChoice.equalsIgnoreCase("halfprice")) {
            discount = new HalfPriceDiscount("50% discount");
        } else {
            discount = new TenPercentDiscount("10% discount");
        }

        while (keepRunning) {
            int userChoice = outInputHandler.menu();

            switch (userChoice) {
                case 1 -> {
                    Product product = createProduct();
                    saveProductToStorage(product);
                }
                case 2 -> listAllProducts(discount);
                case 3 -> searchProduct(discount);
                case 4 -> keepRunning = false;
            }
        }

    }

    private Product createProduct() {
        String articleNumber = outInputHandler.prompt("Article number: ");
        String title = outInputHandler.prompt("Title: ");
        double price = Double.parseDouble(outInputHandler.prompt("Price: "));
        String description = outInputHandler.prompt("Description: ");

        return new Product(articleNumber, title, price, description);
    }

    private void listAllProducts(Discount discount) {
        List<Product> products = getProductsFromStorage();

        for (Product product : products) {
            outInputHandler.info(product + " discount price: " + discount.calculatePrice(product.getPrice()));
        }

    }

    private void searchProduct(Discount discount) {
        String articleNumber = outInputHandler.prompt("Article number search: ");

        Product product = getProductFromStorage(articleNumber);

        if (product == null) {
            outInputHandler.info("Product with given article number does not exist");
            return;
        }

        outInputHandler.info(product + " discount price: " + discount.calculatePrice(product.getPrice()));
    }

}
