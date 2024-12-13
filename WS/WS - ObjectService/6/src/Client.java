package src;

import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.ProductY;

public class Client {
    public static void main(String[] args) {
        ObjectService_Service objectService_Service = new ObjectService_Service();
        ObjectService objectService = objectService_Service.getObjectServicePort();
        ProductY productY = objectService.requestProductY("B21DCCN002", "itT8hvxF");
        float finalPrice = productY.getPrice() * (1 + productY.getTaxRate() / 100) * (1 - productY.getDiscount() / 100);
        productY.setFinalPrice(finalPrice);
        objectService.submitProductY("B21DCCN002", "itT8hvxF", productY);
    }
}
