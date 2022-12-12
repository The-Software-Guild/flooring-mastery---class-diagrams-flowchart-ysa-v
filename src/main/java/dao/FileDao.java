package dao;

import dto.Order;

import java.util.List;
import java.util.Map;

public interface FileDao {

    public Order unmarshallOrder(String line, String orderDate);
    public String marshallOrder (Order order);
    public void writeFile(List<Order> list) throws FlooringMasteryException;
    public Map<Integer, Order> readFile(String file) throws FlooringMasteryException;
}
