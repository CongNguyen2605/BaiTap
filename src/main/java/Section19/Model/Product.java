package Section19.Model;

public class Product {
    private int idProduct;
    private String name;
    private int quantity;
    private int price;
    private int idCategory;

    public Product(int idProduct, String name, int quantity, int price, int idCategory) {
        this.idProduct = idProduct;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Product() {
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", idCategory=" + idCategory +
                '}';
    }
}
