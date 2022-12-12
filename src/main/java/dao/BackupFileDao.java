package dao;

import dto.Order;

import java.util.List;

public interface BackupFileDao {

    public String marshallOrder (Order order);
    public void writeFile(List<Order> list) throws FlooringMasteryException;
}
