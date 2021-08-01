package checkout;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cashier {
    private final String name;
    public Cashier(String userName) {
        name = userName;
    }


    public Invoice generateCustomerInvoice(Cart cart, BigDecimal amountPaid, double discountPercentage) {
      return new Invoice(cart, amountPaid, discountPercentage, name);
    }


    public CustomerBill generateCustomerBill(Cart cart, double percentageDiscount) {
        return new CustomerBill(cart, percentageDiscount, name);
    }
}
