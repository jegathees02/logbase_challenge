package Search;

import java.util.List;
import java.util.Scanner;

import products.Product;

public class SearchMain {
    public void search(List<Product> products) {
        System.out.println("Select the option");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Category");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the ID");
                // int id = scanner.nextInt();
                int id = Integer.parseInt(scanner.nextLine());
                
                break;
            case 2:
                System.out.println("Enter the Name");
                String name = scanner.nextLine();
                
                break;
            case 3:
                System.out.println("Enter the Category");
                String category = scanner.nextLine();
                
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
