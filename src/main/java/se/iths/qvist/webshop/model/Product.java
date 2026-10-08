package se.iths.qvist.webshop.model;

public class Product {
    private String articleNumber;
    private String title;
    private double price;
    private String description;

    public Product(String articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public static Product fromFileLine(String line) {
        String[] parts = line.split(";");

        if (parts.length != 4) {
            IO.println("Faulty file line provided");
            return null;
        }

        String articleNumber = parts[0];
        String title = parts[1];
        // Need to fail-safe later to make sure it actually returns an double.
        double price = Double.parseDouble(parts[2]);
        String description = parts[3];

        return new Product(articleNumber, title, price, description);
    }

    // rewrite later to fit JSON files instead
    public String toFileLine() {
        return articleNumber + ";" + title + ";" + price + ";" + description;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
