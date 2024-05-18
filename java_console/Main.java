import java.util.*;

import Variant.Variant;
import products.Product;
import reviews.Review;
import IDAvailability.IdAvailability;
import OpenAI.OpenAIChatAPI;
import Search.SearchMain;
import Sorting.SortingMain;
class Main extends IdAvailability{
    Product productObj  = new Product();
    SearchMain searchMain = new SearchMain();
    List<Product> products = new ArrayList<Product>();

    static Scanner sc = new Scanner(System.in);
    private void addRandomProduct() {
        Random random = new Random();
        int totalloop = 1;
        while(totalloop-- > 0) {
            int id = random.nextInt(100); // Generate a random ID
            String name = "Product " + id; // Generate a random name
            int variantCount = random.nextInt(5) + 1; // Generate a random variant count between 1 and 5
            List<Variant> variants = new ArrayList<Variant>();
            for (int i = 0; i < variantCount; i++) {
                String size = "Size " + (i + 1); // Generate a random size
                String color = "Color " + (i + 1); // Generate a random color
                int quantity = random.nextInt(10) + 1; // Generate a random quantity between 1 and 10
                double variantPrice = random.nextDouble() * 100; // Generate a random price between 0 and 100
                Variant variant = new Variant(size, color, quantity, variantPrice);
                variants.add(variant);
            }
            String description = "Description for Product " + id; // Generate a random description
            String category = "Category " + id; // Generate a random category
            Product product = new Product(id, name, variants, description, new ArrayList<Review>(), category);
            products.add(product);

            // addProduct(product);
        }
    }
    
    private void start() {
        System.out.println("Select an option:");
        System.out.println("1. Add Product");
        System.out.println("2. View Product");
        System.out.println("3. Search Product");
        System.out.println("4. Filter Product");
        System.out.println("5. Exit");
        int option = 0;
        try{
            option = Integer.parseInt(sc.nextLine());
        }
        catch(Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            start();
        }
        switch(option){
            case 1:
                try {
                    System.out.println("Enter Product ID:");
                    // Thread.sleep(1000);
                    int id = 0;
                    try{
                        id = Integer.parseInt(sc.nextLine());
                        if (isIdAvailable(id, products)) {
                            System.out.println("Product ID already exists. Please enter a different ID.");
                            start();
                        } 
                    }
                    catch(Exception e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        start();
                    }
                    System.out.println("Enter Product Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter the number of variants");
                    int variantCount = Integer.parseInt(sc.nextLine());
                    List<Variant> variants = new ArrayList<Variant>();
                    for(int i = 0; i < variantCount; i++){
                        System.out.println("Enter Product Size of variant"+(i+1)+":");
                        String size = sc.nextLine();
                        System.out.println("Enter Product Color of variant"+(i+1)+":");
                        String color = sc.nextLine();
                        System.out.println("Enter Product Quantity of variant"+(i+1)+":");
                        int quantity = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter Product Price of variant"+(i+1)+":");
                        double variantPrice = Double.parseDouble(sc.nextLine());
                        Variant variant = new Variant(size, color, quantity, variantPrice);
                        variants.add(variant);
                    }
                    // System.out.println("Enter Product Quantity:");
                    // int quantity = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter Product Description:");
                    // String description = sc.nextLine();
                    System.out.println("Enter Product Category:");
                    String category = sc.nextLine();
                    String description = "";
                    // description = OpenAIChatAPI.getResponseFromOpenAI("https://m.media-amazon.com/images/I/515tz9-eXBL._AC_SR320,320_.jpg", category);
                    System.out.println("Generating Description....");
                    description = OpenAIChatAPI.getResponseFromOpenAI("https://cdn.shopify.com/s/files/1/0617/2137/8986/files/4_6f700b9e-19cf-4911-8722-1c17c3cb65d8.jpg?v=1692214793", category);
                    // sc1.close();
                    // while( description.length() <= 0) {
                        
                    // }

                    Product product = new Product(id, name, variants,  description, new ArrayList<Review>(), category);
                    addProduct(product);
                } catch (InterruptedException e) {
                    System.out.println("Error while adding product");
                    start();
                }
                break;
            case 2:
                viewProduct();
                break;
            case 3:
                searchMain.search(products);
                // searchProduct();
                start();
                break;

            case 4:
                SortingMain sortMain = new SortingMain();
                System.out.println("Select an option:");
                System.out.println("1. Sort by price");
                System.out.println("2. Main Menu");
                int sortOption = Integer.parseInt(sc.nextLine());
                switch(sortOption){
                    case 1:
                        System.out.println("Select an option:");
                        System.out.println("1. Sort in ascending order");
                        System.out.println("2. Sort in descending order");
                        int orderOption = Integer.parseInt(sc.nextLine());
                        String order = "";
                        if(orderOption == 1){
                            order = "asc";
                        }
                        else if(orderOption == 2){
                            order = "desc";
                        }
                        sortMain.sorting(products, "price", order);
                        start();
                        break;
                    case 2:
                        start();
                        break;
                    default:
                        System.out.println("Invalid option");
                        start();
                }
            
            case 5:
                // System.exit(0);
                // break;
                System.out.println("Thank you for using E-Commerce World");
                System.exit(0);
            // default:
            //     System.out.println("Invalid option");
                // break;
                start();
        }
    }
    
    private void addProduct(Product product) throws InterruptedException {
        products.add(product);
        start();
        // viewProduct();
    }

    private void viewProductById(int id) {
        
        System.out.println("View Product");
        for(Product product: products){
            if(product.getId() == id){
                System.out.println("Product ID: " + product.getId());
                System.out.println("Product Name: " + product.getName());
                // System.out.println("Product Price: " + product.getPrice());
                System.out.println("variant ");
                int ct = 0;
                for(Variant variant: product.getVariants()){
                    ct++;
                    System.out.println("Variant " + ct);
                    System.out.println("Product Size: " + variant.getSize());
                    System.out.println("Product Color: " + variant.getColor());
                    System.out.println("Product Quantity: " + variant.getQuantity());
                    System.out.println("Product Price: " + variant.getPrice());
                    System.out.println();
                }
                System.out.println("Product Description: " + product.getDescription());
                System.out.println("Product Category: " + product.getCategory());
                System.out.println("Product Reviews: ");
                double averageStarValue = 0;
                int cnt = 0;
                for(Review review: product.getReviews()){
                    cnt++;
                    averageStarValue += review.getStarValue();
                    System.out.println("Star Value: " + review.getStarValue());
                    System.out.println("Comment: " + review.getComment());
                }
                System.out.println("Average Star Value: " + averageStarValue/cnt);
            }
        }
        start();
    }
    
    private void viewProduct() {

        if(products.size() == 0){
            System.out.println("No products available");
            start();
            return;
        }
        
        // System.out.println("View Product");
        System.out.println("**************************************************");
        for(Product product: products){
            System.out.println();
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Description: " + product.getDescription());
            System.out.println("Product Category: " + product.getCategory());
            System.out.println("Product Reviews: ");
            int cnt = 0;
            double averageStarValue = 0;
            for(Review review: product.getReviews()){
                cnt++;
                averageStarValue += review.getStarValue();
            }
            System.out.println("Average Star Value: " + averageStarValue/cnt);
            System.out.println();
            System.out.println("**************************************************");
            System.out.println();
        }
        searchById();

        
    }
    private void searchById() {
        System.out.println("Select an option:"); 
        System.out.println("1. View Product by ID");
        System.out.println("2. Go back to main menu");
        int option = Integer.parseInt(sc.nextLine());
        switch(option){
            case 1:
                System.out.println("Enter Product ID: ");
                try{
                    int id = Integer.parseInt(sc.nextLine());
                    if(!isIdAvailable(id, products)){
                        System.out.println("Product ID does not exist. Please enter a valid ID.");
                        searchById();
                    }
                    viewProductById(id);
                }
                catch(Exception e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    searchById();
                }
                break;
            case 2:
                start();
                break;
            default:
                System.out.println("Invalid option");
                searchById();
        }
    }
    
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        System.out.println("E-Commerce World");
        Main main = new Main();
        // main.addRandomProduct();
        main.start();


    }
}