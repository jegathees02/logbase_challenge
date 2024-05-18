package products;

import java.util.List;
import java.util.Map;

import Variant.Variant;
import reviews.Review;

public class Product {
    private int id;
    private String name;
    // private double price;
    private List<Variant> variants;
    private String description;
    private List<Review> reviews;
    private String category;

    public Product(int id, String name, List<Variant> variants,  String description, List<Review> reviews, String category) {
        this.id = id;
        this.name = name;
        // this.price = price;
        this.variants = variants;
        // this.quantity = quantity;
        this.description = description;
        this.reviews = reviews;
        this.category = category;
    }
    public Product() {

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Variant> getVariants() {
        return variants;
    }
    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
    

}
