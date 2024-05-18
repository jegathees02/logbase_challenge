package Search;

import java.util.List;
import java.util.Scanner;

// import Main;

import IDAvailability.IdAvailability;
import products.Product;

public class SearchMain extends IdAvailability {
    SearchById searchbyid = new SearchById();
    IdAvailability idAvailability = new IdAvailability();

    public void search(List<Product> products) {
        System.out.println("Select the option");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Category");
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                System.out.println("Enter the ID");
                // int id = scanner.nextInt();
                // int id = Integer.parseInt(scanner.nextLine());
                try{
                    int id = Integer.parseInt(scanner.nextLine());
                    if(!isIdAvailable(id, products)){
                        System.out.println("Product ID does not exist. Please enter a valid ID.");
                        search(products);
                    }
                    else
                        searchbyid.searchById(products, id);
                }
                catch(Exception e) {
                    System.out.println("Invalid input. Please enter a valid integer."+e);
                    search(products);
                }               

                break;
            case 2:
                System.out.println("Enter the Name");
                String name = scanner.nextLine();
                searchByName searchbyname = new searchByName();
                searchbyname.searchByName(products, name);
                break;
            case 3:
                System.out.println("Enter the Category");
                String category = scanner.nextLine();
                SearchByCategory searchbycategory = new SearchByCategory();
                searchbycategory.searchByCategory(products, category);

                
                break;
            case 4:
                // Main main = new Main();
                // main.start();
                return;
            default:
                search(products);
                // System.out.println("Invalid option");
        }
    }
}
