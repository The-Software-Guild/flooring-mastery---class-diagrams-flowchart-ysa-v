package dao;

import dto.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ProductsFileDaoImpl implements ProductsFileDao{

    private static final String PRODUCTS_FILE = "FileData/Products.txt";
    private static final String DELIMITER = ",";

    @Override
    public Product unmarshallProduct(String line) {
        String[] productTokens = line.split(DELIMITER);
        String productType = productTokens[0];
        BigDecimal costPerSquareFoot = new BigDecimal(productTokens[1]);
        BigDecimal laborCostPerSquareFoot = new BigDecimal(productTokens[2]);

        return new Product(productType, costPerSquareFoot, laborCostPerSquareFoot);
    }

    @Override
    public Map<String, Product> loadProducts() throws FlooringMasteryException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCTS_FILE)));
        } catch (FileNotFoundException e){
            throw new FlooringMasteryException("Products file not found", e);
        }
        return null;
    }
}
