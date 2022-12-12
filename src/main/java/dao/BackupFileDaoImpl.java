package dao;

import dto.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class BackupFileDaoImpl implements BackupFileDao{

    private static String BACKUP_FILE = "FileData/Backup/DataExport.txt";
    private static final String DELIMITER = ",";

    @Override
    public String marshallOrder(Order order) {
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
                order.getTotal() + DELIMITER +
                order.getOrderDate();
    }

    @Override
    public void writeFile(List<Order> list) throws FlooringMasteryException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(BACKUP_FILE));
        }
        catch (IOException e) {
            throw new FlooringMasteryException("Could not export order data", e);
        }

        String orderAsText;
        for (Order currentOrder : list) {
            orderAsText = marshallOrder(currentOrder);
            out.println(orderAsText);
            out.flush();
        }
        out.close();
    }
}
