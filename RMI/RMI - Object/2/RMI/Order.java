package RMI;

import java.io.Serializable;

public class Order implements Serializable {
    private String id;
    private String customerCode;
    private String orderDate;
    private String shippingType;
    private String orderCode;
    private static final long serialVersionUID = 20241132L;
    public Order(){
        this.id = "";
        this.customerCode = "";
        this.orderCode = "";
        this.shippingType = "";
        this.orderDate = "";
    }

    public Order(String id, String customerCode, String orderDate, String shippingType) {
        this.id = id;
        this.customerCode = customerCode;
        this.orderDate = orderDate;
        this.shippingType = shippingType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingTypel) {
        this.shippingType = shippingTypel;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerCode=" + customerCode + ", orderDate=" + orderDate + ", shippingTypel=" + shippingType + ", orderCode=" + orderCode + '}';
    }
    
}