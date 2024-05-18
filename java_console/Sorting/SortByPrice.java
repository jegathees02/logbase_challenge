package Sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Variant.Variant;
import products.Product;

public class SortByPrice implements Comparator<Product> {
    public int compare(Product a, Product b) {
        List<Variant> variantsA = a.getVariants();
        List<Variant> variantsB = b.getVariants();
        double priceA = 0;
        double priceB = 0;
        // int cnt = 0;
        for (Variant variant : variantsA) {
            priceA += variant.getPrice();
            break;
        }
        for (Variant variant : variantsB) {
            priceB += variant.getPrice();
            break;
        }
        return (int) (priceA - priceB);
    }

    public void sortASC(List<Product> products) {
        Collections.sort(products, new SortByPrice());

        for (Product product : products) {
            System.out.println(product.getName());
            System.out.println(product.getVariants().get(0).getPrice());
            
        }
    }

    public void sortDESC(List<Product> products) {
        Collections.sort(products, new SortByPrice().reversed());

        for (Product product : products) {
            System.out.println(product.getName());
            System.out.println(product.getVariants().get(0).getPrice());
        }
    }
}
