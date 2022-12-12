package dao;

import dto.Order;
import dto.Product;
import dto.StateTax;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FlooringMasteryDaoTest {

    FlooringMasteryDao fDao = new FlooringMasteryDaoImpl();

    FlooringMasteryDaoTest() throws FlooringMasteryException {
    }

    @org.junit.jupiter.api.Test
    void testAddAndGetOrder() throws FlooringMasteryException {
        Order order = new Order("Test Customer",
                new BigDecimal(100),
                new StateTax("TT", "Test State",new BigDecimal(.1)),
                new Product("Test Product", new BigDecimal(1), new BigDecimal(2)));
        order = fDao.addOrder(order);

        Order fromDao = fDao.getOrder(order.getOrderNumber(), order.getOrderDate());
        assertEquals(order, fromDao);
    }

    @org.junit.jupiter.api.Test
    void listAllOrdersFromDate() {
    }

    @org.junit.jupiter.api.Test
    void listAllOrders() {
    }

    @org.junit.jupiter.api.Test
    void addOrder() {
    }

    @org.junit.jupiter.api.Test
    void removeOrder() {
    }

    @org.junit.jupiter.api.Test
    void exportData() {
    }
}