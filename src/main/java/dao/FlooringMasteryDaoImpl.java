package dao;

import dto.Order;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlooringMasteryDaoImpl implements FlooringMasteryDao {

    Map<Integer, Order> orderMap;
    FileDao fio;
    BackupFileDao bfio;
    private static final String ORDER_DIRECTORY = "FileData/Orders";
    private static final String ORDER_FILE_PREFIX = "FileData/Orders/Orders_";

    public FlooringMasteryDaoImpl() throws FlooringMasteryException {
        fio = new FileDaoImpl();
        bfio = new BackupFileDaoImpl();
    }
    @Override
    public Order getOrder(int orderNumber, String date) throws FlooringMasteryException {
        orderMap = fio.readFile(ORDER_FILE_PREFIX + removeDashesFromDate(date));
        return orderMap.get(orderNumber);
    }

    @Override
    public List<Order> listAllOrdersFromDate(String date) throws FlooringMasteryException {
        orderMap = fio.readFile(ORDER_FILE_PREFIX + removeDashesFromDate(date));
        return new ArrayList<>(orderMap.values());
    }

    public List<Order> listAllOrders() throws FlooringMasteryException {
        File[] orderFiles = new File(ORDER_DIRECTORY).listFiles();
        List<Order> orderList = new ArrayList<Order>();

        for (File file: orderFiles) {
            orderList.addAll(fio.readFile(file.toString()).values());
        }
        return orderList;
    }

    @Override
    public Order addOrder(Order order) throws FlooringMasteryException {
        orderMap = fio.readFile(ORDER_FILE_PREFIX + removeDashesFromDate(order.getOrderDate()));
        Order res = orderMap.put(order.getOrderNumber(), order);
        fio.writeFile(new ArrayList<Order>(orderMap.values()));
        return res;
    }

    @Override
    public Order removeOrder(Order order) throws FlooringMasteryException {
        orderMap = fio.readFile(ORDER_FILE_PREFIX + removeDashesFromDate(order.getOrderDate()));
        Order res = orderMap.remove(order.getOrderNumber());
        fio.writeFile(new ArrayList<Order>(orderMap.values()));
        return res;
    }

    @Override
    public void exportData(List<Order> orders) throws FlooringMasteryException {
        bfio.writeFile(orders);
    }

//    public String addDashesToDate(String undashedDate) {
//        return null;
//    }

    public String removeDashesFromDate (String dashedDate) {
        if (dashedDate.contains("-")) {
            String[] dateArray = dashedDate.split("-");
            return dateArray[0] + dateArray[1] + dateArray[2];
        } else {
            return dashedDate;
        }
    }
}
