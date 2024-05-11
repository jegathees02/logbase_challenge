package IDAvailability;

import java.util.List;

import products.Product;

public class IdAvailability {
    public boolean isIdAvailable(int id, List<Product> products) {
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
