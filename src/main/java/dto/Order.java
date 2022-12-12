package dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Order {

    private String orderDate;
    private static int nextOrderNumber = 0;
    private int orderNumber;
    private String customerName;
    private BigDecimal area;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal total;
    private BigDecimal tax;

    public StateTax stateTax;
    public Product product;


    public Order(String customerName, BigDecimal area, StateTax stateTax, Product product) {
        this.orderNumber = nextOrderNumber;
        nextOrderNumber++;
        this.customerName = customerName;
        this.area = area;
        this.materialCost = area.multiply(product.getCostPerSquareFoot());
        this.laborCost = area.multiply(product.getLaborCostPerSquareFoot());
        this.tax = (this.materialCost.add(this.laborCost)).multiply(stateTax.getTaxRate().divide(new BigDecimal(100)));
        this.total = this.materialCost.add(this.laborCost.add(this.tax));
        this.orderDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMddyyyy"));
        this.stateTax = stateTax;
        this.product = product;
    }
    public Order(int orderNumber, String customerName, BigDecimal area, BigDecimal materialCost, BigDecimal laborCost, BigDecimal tax, BigDecimal total, String orderDate, StateTax stateTax, Product product) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.area = area;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.tax = tax;
        this.total = total;
        this.orderDate = orderDate;
        this.stateTax = stateTax;
        this.product = product;
    }

    public String getOrderDate() {
        return orderDate;
    }
    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getOrderNumber() == order.getOrderNumber() && getOrderDate().equals(order.getOrderDate()) && getCustomerName().equals(order.getCustomerName()) && getArea().equals(order.getArea()) && getMaterialCost().equals(order.getMaterialCost()) && getLaborCost().equals(order.getLaborCost()) && getTotal().equals(order.getTotal()) && getTax().equals(order.getTax()) && stateTax.equals(order.stateTax) && product.equals(order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderDate(), getOrderNumber(), getCustomerName(), getArea(), getMaterialCost(), getLaborCost(), getTotal(), getTax(), stateTax, product);
    }
}
