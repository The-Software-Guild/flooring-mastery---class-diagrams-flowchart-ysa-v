package dao;

import dto.Product;

import java.util.Map;

public interface ProductsFileDao {

    public Product unmarshallProduct(String line);

    public Map<String, Product> loadProducts() throws FlooringMasteryException;

}
