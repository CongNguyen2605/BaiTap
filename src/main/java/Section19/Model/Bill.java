package Section19.Model;

public class Bill {
    private int idBill;
    private int quantity;
    private int price;
    private int idProduct;
    private String buyDate;

    public Bill(int idBill, int quantity, int price, int idProduct, String buyDate) {
        this.idBill = idBill;
        this.quantity = quantity;
        this.price = price;
        this.idProduct = idProduct;
        this.buyDate = buyDate;
    }

    public Bill() {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", quantity=" + quantity +
                ", price=" + price +
                ", idProduct=" + idProduct +
                ", buyDate='" + buyDate + '\'' +
                '}';
    }
}
