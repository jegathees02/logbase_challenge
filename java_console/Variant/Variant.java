package Variant;

public class Variant {
    private String size;
    private String color;
    private int quantity;
    private double price;

    public Variant(String size, String color, int quantity, double price) {
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    public Variant() {
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
