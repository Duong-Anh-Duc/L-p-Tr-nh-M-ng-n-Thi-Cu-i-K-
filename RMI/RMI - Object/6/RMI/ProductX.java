package RMI;

import java.io.Serializable;

public class ProductX implements Serializable {
    private static final long serialVersionUID = 20171107; 
    private String id;
    private String code;
    private String discountCode;
    private int discount;

    public ProductX(String id, String code, String discountCode, int discount) {
        this.id = id;
        this.code = code;
        this.discountCode = discountCode;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "ProductX{" + "id=" + id + ", code=" + code + ", discountCode=" + discountCode + ", discount=" + discount + '}';
    }
    
}