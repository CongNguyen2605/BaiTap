package Section8.Models;

import java.util.List;
import java.util.Scanner;

public class Person {
    private long cccd;
    private String ten;
    private int tuoi;
    private List<Car> carList;
    private List<House> houses;

    public long getCccd() {
        return cccd;
    }

    public void setCccd(long cccd) {
        this.cccd = cccd;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        cccd = scanner.nextLong();
        ten = scanner.next();
        tuoi = scanner.nextInt();
    }
    public void infor(){
        System.out.println(getCccd());
        System.out.println(getTen());
        System.out.println(getTuoi());
        System.out.println("Danh sach xe:");
        for (Car car : carList) {
            car.infor();
        }
        System.out.println("Danh sach nha:");
        for (House house : houses) {
            house.infor();
        }

    }
}
