package ui;

import dto.Order;

import java.math.BigDecimal;
import java.util.List;

public class FlooringMasteryView {

    private UserIO io;

    public FlooringMasteryView () { io = new UserIOImpl(); }

    public FlooringMasteryView (UserIO io) { this.io = io; }

    public void printMenu() {
        mainMenuBanner();
        io.print("1. Display Orders");
        io.print("2. Add an Order");
        io.print("3. Edit an Order");
        io.print("4. Remove an Order");
        io.print("5. Export All Data");
        io.print("6. Quit");
    }

    public int getMenuSelection() {
        return io.readInt("Enter menu selection: ", 1, 6);
    }

    public void displayOrder(Order order) {
        io.print("Order Number:" + order.getOrderNumber());
        io.print("Customer:" + order.getCustomerName());
        io.print("State:" + order.stateTax.getStateAbbreviation());
        io.print("Product Type:" + order.product.getProductType());
        io.print("Area:" + order.getArea());
        io.print("Material Cost:" + order.getMaterialCost());
        io.print("Labor Cost:" + order.getLaborCost());
        io.print("Tax:" + order.getTax());
        io.print("Total:" + order.getTotal() + "\n");
    }
    public void displayOrders(List<Order> orders) {
        for (Order order: orders) {
            displayOrder(order);
        }
    }

    public String toBeRemoved(Order order) {
        removeOrderBanner();
        displayOrder(order);
        return io.readString("\nAre you sure you want to remove the above order? Type anything for 'yes', hit enter for 'no': ");
    }

    public int getOrderNumberInput(){
        return io.readInt("Enter order number: ");
    }

    public String getDateInput(){
        return io.readString("Enter order date (MM-DD-YYYY): ");
    }

    public String getCustomerInput() {
        return io.readString("Enter customer name : ");
    }

    public String getStateInput() {
        return io.readString("Enter state abbreviation: ");
    }

    public String getProductTypeInput() {
        return io.readString("Enter product type: ");
    }

    public BigDecimal getAreaInput() {
        return io.readBigDecimal("Enter area: ", new BigDecimal(100));
    }

    public String editCustomerName(String currentName) {
        return io.readString("Enter customer name (" + currentName + "):");
    }

    public String editState(String currentState) {
        return io.readString("Enter state abbreviation (" + currentState + "):");
    }

    public String editProductType(String currentType) {
        return io.readString("Enter customer name (" + currentType + "):");
    }

    public BigDecimal editArea(BigDecimal currentArea) {
        return io.readBigDecimal("Enter customer name (" + currentArea + "):", new BigDecimal(100));
    }

    public void mainMenuBanner(){
        io.print("======Flooring Program========\n");
    }

    public void displayOrdersBanner(){io.print("======Display Orders========\n");
    }

    public void addOrderBanner(){
        io.print("======Add Order========\n");
    }

    public void editOrderBanner(){
        io.print("======Edit Order========\n");
    }

    public void removeOrderBanner(){
        io.print("======Remove Order========\n");
    }

    public void exportDataBanner(){
        io.print("======Export Data========\n");
    }

    public void quitMessage(){
        io.print("Goodbye" + "\n");
    }

    public void displayErrorMessage(String message)
    {
        io.print(message + '\n');
        io.readString("Please hit enter to continue.");
    }
}
