package checkout;

import java.math.BigDecimal;

public class Product {
    private final String productName;
    private final BigDecimal productPrice;

    public Product(String productName, BigDecimal productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return productPrice;
    }
}
