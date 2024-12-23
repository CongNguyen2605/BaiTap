package Section8.Bai2.Main;

import Section8.Bai2.Model.Country;
import Section8.Bai2.Model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Them quoc gia");
            System.out.println("2. Them nguoi");
            System.out.println("3. In thong tin nguoi");
            System.out.println("4. In thong tin quoc gia");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: {
                    Country country = new Country();
                    country.input();
                    countries.add(country);
                    break;
                }
                case 2: {
                    if (countries.isEmpty()) {
                        System.out.println("Chua co quoc gia nao. Vui long them quoc gia truoc.");
                        break;
                    }
                    Person person = new Person();
                    person.input();
                    System.out.print("Nhap ten quoc gia: ");
                    String countryName = scanner.nextLine();

                    boolean found = false;
                    for (Country country : countries) {
                        if (country.getTen().equalsIgnoreCase(countryName)) {
                            country.addPerson(person);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Khong tim thay quoc gia co ten: " + countryName);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Danh sach nguoi:");
                    for (Country country : countries) {
                        for (Person person : country.getPersonList()) {
                            person.infor();
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Danh sach quoc gia:");
                    for (Country country : countries) {
                        country.infor();
                    }
                    break;
                }
                case 0: {
                    System.out.println("Thoat chuong trinh.");
                    break;
                }
                default: {
                    System.out.println("Lua chon khong hop le.");
                }
            }
        } while (choice != 0);
    }
}
