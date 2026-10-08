package se.iths.qvist.webshop;


public class Main {
    static void main() {
        ProductFileStorage productFileStorage = new ProductFileStorage();
        WebShopManager webShopManager = new WebShopManager(productFileStorage);
    }
}
