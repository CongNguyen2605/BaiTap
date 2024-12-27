package Section19.Dao;

import Section19.Model.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    Product findById(int id);
    List<Product> allProduct();
    List<Product> findAllProductByName(String name);
    List<Product> findAllProductByPrice(int priceMin , int priceMax);
}
