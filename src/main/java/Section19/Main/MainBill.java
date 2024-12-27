package Section19.Main;

import Section19.Dao.BillDao;
import Section19.Dao.DaoImpl.BillDaoImpl;
import Section19.Dao.DaoImpl.ProductDaoImpl;
import Section19.Model.Bill;
import Section19.Model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainBill {
    public static void main(String[] args) {
        BillDao billDao = new BillDaoImpl();
        ProductDaoImpl productDao = new ProductDaoImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- Shop Management System -----");
            System.out.println("1. Add Bill");
            System.out.println("2. Search Bills by Date Range");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    Product product = productDao.findById(productId);

                        if (product.getQuantity() > quantity ){
                            billDao.muaHang(new Bill(0,quantity,product.getPrice(),productId, LocalDate.now().toString()));
                            product.setQuantity(product.getQuantity() - quantity);
                            productDao.updateProduct(product);
                            break;}
                        case 2:
                            System.out.print("Enter product fromDate: ");
                        String fromDate = scanner.next();
                            System.out.print("Enter product toDate: ");
                        String toDate = scanner.next();
                        billDao.search(fromDate,toDate).forEach(System.out::println);

                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        scanner.close();
    }
}
