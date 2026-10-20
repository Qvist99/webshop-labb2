package se.iths.qvist.webshop;


public class Main {
    static void main() {
        ProductFileStorage productFileStorage = new ProductFileStorage();
        OutInputHandler consoleOutInputHandler = new ConsoleOutInputHandler();
        WebShopManager webShopManager = new WebShopManager(productFileStorage, consoleOutInputHandler);

        webShopManager.startWebshop();
    }
}
