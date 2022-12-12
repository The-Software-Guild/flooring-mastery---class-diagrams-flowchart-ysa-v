package service;

import dto.Order;

import java.util.List;

public interface FlooringMasteryService {

    void displayOrders(List<Order> orders);
    void convertAndConfirmDate(String date);
    void addAnOrder(Order order);
    void editAnOrder(Order order);
    void removeAnOrder(Order order);
//    void exportAllData();
}
