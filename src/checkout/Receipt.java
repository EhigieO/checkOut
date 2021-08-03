package checkout;

import java.math.BigDecimal;

public class Receipt implements Printable {
    private final String invoice;

    public Receipt(Cart cart, BigDecimal amountPaid, double discountPercentage, String cashierName) {
        invoice = Printable.generateCustomerReceipt(cart, amountPaid, discountPercentage, cashierName);
    }

    @Override
    public void print() {
        System.out.println(invoice);
    }


}
