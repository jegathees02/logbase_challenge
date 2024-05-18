package Sorting;

import java.util.List;

import products.Product;

public class SortingMain {
    public void sorting(List<Product> products, String sortBy, String order) {
        if (sortBy.equals("price")) {
            SortByPrice sortByPrice = new SortByPrice();
            if (order.equals("asc")) {
                sortByPrice.sortASC(products);
            } else if (order.equals("desc")) {
                sortByPrice.sortDESC(products);
            }
        }

    }
}
