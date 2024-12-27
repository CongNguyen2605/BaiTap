package Section18.Bai1.Main;

import Section18.Bai1.Dao.DaoImpl.UniversityDaoImpl;
import Section18.Bai1.Dao.UniversityDao;
import Section18.Bai1.Model.University;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UniversityDao universityDao = new UniversityDaoImpl();
        int a;

        do {
            System.out.println("1.Hien Thi Danh Sach \n" +
                    "2.Them Truong Dai Hoc \n" +
                    "3.Sua Truong Dai Hoc \n" +
                    "4.Tim Truong Dai Hoc \n" +
                    "5.Xoa Truong Dai Hoc \n" +
                    "6.thoat");
            System.out.println("Nhap Lua Chon : ");
            a = scanner.nextInt();
            if(a==1){

              universityDao.getAllUniversities().forEach(System.out::println);
            }
            if(a==2){
                University university = new University();
                System.out.println("nhap id");
                university.setId(scanner.nextLong());
                System.out.println("nhap name");
                university.setName(scanner.next());
                System.out.println("nhap address");
                university.setAddress(scanner.next());
                universityDao.addUniversity(university);
            }
            if (a==3){
                System.out.println("nhap id :");
                int id = scanner.nextInt();
                universityDao.updateUniversity(id);
            }
            if (a==4){
                System.out.println("nhap id :");
                int id = scanner.nextInt();
                universityDao.findById(id);

            }
            if(a==5){
                System.out.println("nhap id :");
                int id = scanner.nextInt();
                universityDao.deleteUniversity(id);
            }


        }while (a!=0);
    }
}
