package se.iths.qvist.webshop;

public interface OutInputHandler {
    String prompt(String message);

    void info(String message);

    int menu();
}
