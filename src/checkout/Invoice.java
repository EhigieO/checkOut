package checkout;

import java.math.BigDecimal;

public class Invoice implements Printable {
    private final String invoice;

    public Invoice(Cart cart, BigDecimal amountPaid, double discountPercentage, String cashierName) {
        invoice = Printable.generateCustomerInvoice(cart, amountPaid, discountPercentage, cashierName);
    }

    @Override
    public void print() {
        System.out.println(invoice);
    }


}
