package dao;

import dto.Order;

import java.util.List;

public interface FlooringMasteryDao {

    Order getOrder(int orderNumber, String date) throws FlooringMasteryException;
    List<Order> listAllOrdersFromDate(String date) throws FlooringMasteryException;
    List<Order> listAllOrders() throws FlooringMasteryException;
    Order addOrder(Order order) throws FlooringMasteryException;
    Order removeOrder(Order order) throws FlooringMasteryException;
    void exportData(List<Order> orders) throws FlooringMasteryException;
}
