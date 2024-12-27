package Section19.Main;

import Section18.Bai2.Model.Student;
import Section18.Bai2.Model.University;
import Section19.Dao.CategoryDao;
import Section19.Dao.DaoImpl.CategoryDaoImpl;
import Section19.Dao.DaoImpl.ProductDaoImpl;
import Section19.Dao.ProductDao;
import Section19.Model.Category;
import Section19.Model.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDaoImpl();
        ProductDao productDao = new ProductDaoImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- Management System -----");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Find Product by Name");
            System.out.println("5. Filter Product by Price");
            System.out.println("6. Add Category");
            System.out.println("7. Update Category");
            System.out.println("8. Delete Category");
            System.out.println("9. Find all Category");
            System.out.println("11. Find all product");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product id: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    int price = scanner.nextInt();
                    System.out.print("Enter category id: ");
                    int idCategory = scanner.nextInt();
                    productDao.addProduct(new Product(id, productName, quantity, price,idCategory));
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.print("Enter product ID to update: ");
                    int idProduct = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter new product name: ");
                    productName = scanner.nextLine();
                    System.out.print("Enter new product quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter new price : ");
                    price = scanner.nextInt();
                    System.out.print("Enter new category : ");
                    idCategory = scanner.nextInt();
                    productDao.updateProduct(new Product(idProduct, productName, quantity, price,idCategory));
                    System.out.println("Product updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    idProduct = scanner.nextInt();
                    productDao.deleteProduct(idProduct);
                    System.out.println("Student deleted successfully!");
                    break;

                case 4:
                    System.out.print("Enter product name to search: ");
                    productName = scanner.nextLine();
                    productDao.findAllProductByName(productName).forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Filter product by price to search: ");
                    System.out.println("nhap gia :");
                    int priceMin = scanner.nextInt();
                    System.out.println("nhap gia : ");
                    int priceMax = scanner.nextInt();
                    productDao.findAllProductByPrice(priceMin,priceMax).forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Enter category id: ");
                    int idcategory = scanner.nextInt();
                    System.out.print("Enter category name: ");
                    String nameCategory = scanner.next();
                    categoryDao.addCategory(new Category(idcategory, nameCategory));
                    System.out.println("category added successfully!");
                    break;

                case 7:
                    System.out.print("Enter category ID to update: ");
                    idcategory = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter new category name: ");
                    nameCategory = scanner.nextLine();
                    categoryDao.updateCategory(new Category(idcategory, nameCategory));
                    System.out.println("Category updated successfully!");
                    break;

                case 8:
                    System.out.print("Enter Category ID to delete: ");
                    idcategory = scanner.nextInt();
                    categoryDao.deleteCategory(idcategory);
                    System.out.println("Category deleted successfully!");
                    break;

                case 9:
                    categoryDao.allCategory().forEach(System.out::println);
                    break;
                case 11:
                    productDao.allProduct().forEach(System.out::println);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 10);

        scanner.close();
    }
}
