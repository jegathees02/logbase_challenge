package Search;

import java.util.List;

import products.Product;

public class SearchByCategory {
    public void searchByCategory(List<Product> products, String category) {
        try{
            System.out.println("Searching by Category");
            System.out.println("**************************************************");
            System.out.println();
            boolean found = false;
            for (Product product : products) {
                if (product.getCategory().equals(category)) {
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
                }
                System.out.println("**************************************************");
                System.out.println();
            }
            if (!found) {
                System.out.println("Product not found");
                SearchMain searchMain = new SearchMain();
                searchMain.search(products);
            }
        }
        catch(Exception e) {
            System.out.println("Invalid input. Please enter a valid category."+e);
            SearchMain searchMain = new SearchMain();
            searchMain.search(products);
        }
    }
}
