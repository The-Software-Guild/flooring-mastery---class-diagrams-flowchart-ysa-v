package dao;

import dto.Order;
import dto.Product;
import dto.StateTax;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileDaoImpl implements FileDao {

    private static String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MMddyyyy"));
    private static String ORDER_FILE = "FileData/Orders/Orders_" + date + ".txt";
    private static final String DELIMITER = ",";

    private Map<Integer, Order> orderMap = new HashMap<>();

    @Override
    public Order unmarshallOrder(String line, String orderDate) {
        String[] orderTokens = line.split(DELIMITER);
        int orderNumber = Integer.parseInt(orderTokens[0]);
        String customerName = orderTokens[1];
        String stateAbbreviation = orderTokens[2];
        BigDecimal taxRate = new BigDecimal(orderTokens[3]);
        String productType = orderTokens[4];
        BigDecimal area = new BigDecimal(orderTokens[5]);
        BigDecimal costPerSquareFoot = new BigDecimal(orderTokens[6]);
        BigDecimal laborCostPerSquareFoot = new BigDecimal(orderTokens[7]);
        BigDecimal materialCost = new BigDecimal(orderTokens[8]);
        BigDecimal laborCost = new BigDecimal(orderTokens[9]);
        BigDecimal tax = new BigDecimal(orderTokens[10]);
        BigDecimal total = new BigDecimal(orderTokens[11]);

        Product product = new Product(productType, costPerSquareFoot, laborCostPerSquareFoot);
        StateTax stateTax = new StateTax(stateAbbreviation, null, taxRate);

        return new Order(orderNumber, customerName, area, materialCost, laborCost, tax, total, orderDate, stateTax, product);
    }
    @Override
    public String marshallOrder (Order order) {
        return order.getOrderNumber() + DELIMITER +
                order.getCustomerName() + DELIMITER +
                order.stateTax.getStateAbbreviation() + DELIMITER +
                order.stateTax.getTaxRate() + DELIMITER +
                order.product.getProductType() + DELIMITER +
                order.getArea() + DELIMITER +
                order.product.getCostPerSquareFoot() + DELIMITER +
                order.product.getLaborCostPerSquareFoot() + DELIMITER +
                order.getMaterialCost() + DELIMITER +
                order.getLaborCost() + DELIMITER +
                order.getTax() + DELIMITER +
                order.getTotal();
    };
    @Override
    public void writeFile(List<Order> list) throws FlooringMasteryException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ORDER_FILE));
        }
        catch (IOException e) {
            throw new FlooringMasteryException("Could not save order data", e);
        }

        String orderAsText;
        for (Order currentOrder : list) {
            orderAsText = marshallOrder(currentOrder);
            out.println(orderAsText);
            out.flush();
        }
        out.close();
    }
    @Override
    public Map<Integer, Order> readFile(String file) throws FlooringMasteryException {
        Scanner scanner;

        try {
            scanner = new Scanner((new BufferedReader(new FileReader(file))));
        }
        catch(FileNotFoundException e)
        {
            throw new FlooringMasteryException("File not found", e);
        }

        String currentLine;
        Order currentOrder;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentOrder = unmarshallOrder(currentLine,
                    file.substring(file.length() - 8, file.length() - 6)
                            + "-" + file.substring(file.length()-6, file.length() -4)
                            + "-" + file.substring(file.length()-4));
            orderMap.put(currentOrder.getOrderNumber(), currentOrder);
        }
        return orderMap;
    }
}
