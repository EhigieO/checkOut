package checkout;

import java.math.BigDecimal;
import java.util.Formatter;

public class Item {
    private final Product product;
    private final int quantityPurchased;

    public Item(String itemName, BigDecimal unitPrice, int quantityPurchased) {
        product = new Product(itemName, unitPrice);
        this.quantityPurchased = quantityPurchased;
    }

    public String getProductName() {
        return product.getName();
    }

    public BigDecimal getProductPrice() {
        return product.getPrice();
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public BigDecimal calculatePrice() {
        return getProductPrice().multiply(BigDecimal.valueOf(quantityPurchased));
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        return String.format("%25s    %3d  %8.2f     %8.2f", formatter.format(product.getName()), quantityPurchased, product.getPrice().floatValue(), calculatePrice());
    }

}
