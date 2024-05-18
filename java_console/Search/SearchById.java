package Search;

import java.util.List;

import products.Product;

public class SearchById {
    public void searchById(List<Product> produts ,int id) {
        System.out.println("Searching by ID");
        boolean found = false;
        for (Product product : produts) {
            if (product.getId() == id) {
                found = true;
                System.out.println("Product found");
                System.out.println("ID: " + product.getId());
                System.out.println("Name: " + product.getName());
                System.out.println("Description: " + product.getDescription());
                System.out.println("Category: " + product.getCategory());
                System.out.println("Variants: ");
                for (int i = 0; i < product.getVariants().size(); i++) {
                    System.out.println("Variant " + (i + 1));
                    System.out.println("Color: " + product.getVariants().get(i).getColor());
                    System.out.println("Price: " + product.getVariants().get(i).getPrice());
                    System.out.println("Quantity: " + product.getVariants().get(i).getQuantity());
                }
                System.out.println("Reviews: ");
                for (int i = 0; i < product.getReviews().size(); i++) {
                    System.out.println("Review " + (i + 1));
                    System.out.println("Rating: " + product.getReviews().get(i).getStarValue());
                    System.out.println("Comment: " + product.getReviews().get(i).getComment());
                }
                return;
            }
        }
        if (!found) {
            System.out.println("Product not found");
            SearchMain searchMain = new SearchMain();
            searchMain.search(produts);
        }
    }
}
