package Search;

import java.util.List;
import java.util.Scanner;

import Variant.Variant;
import products.Product;
import reviews.Review;

public class searchByName {
    SearchMain searchMain = new SearchMain();
    public void searchByName(List<Product> products, String name) {
        try{
            name = name.toLowerCase().trim();
            boolean flag = false;
            for (Product product : products) {
                if (product.getName().equals(name)) {
                    flag = true;
                    System.out.println("Product ID: " + product.getId());
                    System.out.println("Product Name: " + product.getName());
                    // System.out.println("Product Price: " + product.getPrice());
                    // System.out.println("Product Quantity: " + product.getQuantity());
                    System.out.println("Product Variants: ");
                    for (Variant variant : product.getVariants()) {
                        System.out.println("Size: " + variant.getSize());
                        System.out.println("Color: " + variant.getColor());
                        System.out.println("Quantity: " + variant.getQuantity());
                        System.out.println("Price: " + variant.getPrice());
                    }
                    System.out.println("Product Reviews: ");
                    for (Review review : product.getReviews()) {
                        System.out.println("Star Value: " + review.getStarValue());
                        System.out.println("Comment: " + review.getComment());
                    }
                    System.out.println("Product Category: " + product.getCategory());
                    System.out.println("Product Description: " + product.getDescription());
                }
            }
            if(!flag) {
                System.out.println("Product not found. Please enter a valid name.");
                searchMain.search(products);
            }
        }
        catch(Exception e) {
            System.out.println("Invalid input. Please enter a valid name."+e);
            searchMain.search(products);
        }
    }
}
