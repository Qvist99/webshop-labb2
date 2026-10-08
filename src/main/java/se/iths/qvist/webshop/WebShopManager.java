package se.iths.qvist.webshop;

import se.iths.qvist.webshop.model.Discount;
import se.iths.qvist.webshop.model.HalfPriceDiscount;
import se.iths.qvist.webshop.model.Product;
import se.iths.qvist.webshop.model.TenPercentDiscount;

import java.util.List;

public class WebShopManager {
    private ProductStorage productStorage;

    public WebShopManager(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public void saveProductToStorage(Product product) {

    }

    public List<Product> getProductsFromStorage() {


        return null;
    }

    public Product getProductFromStorage(String articleNumber) {
        return null;
    }

    public void startWebshop() {
        String userDiscountChoice = IO.readln("Enter your discount code");
        Discount discount = null;

        if (userDiscountChoice.equalsIgnoreCase("halfprice")) {
            discount = new HalfPriceDiscount("50% discount");
        } else {
            discount = new TenPercentDiscount("10% discount");
        }

        //Do while loop until user decides to exit program
        //Menu choices
        /*
         * 1. Add product
         * 2. List all products
         * 3. Display product info
         * 4. Exit application
         *
         *
         *
         * */

    }

}
