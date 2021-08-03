package checkout;

import java.math.BigDecimal;

public class Cashier {
    private final String name;

    public Cashier(String userName) {
        name = userName;
    }


    public Receipt generateCustomerReceipt(Cart cart, BigDecimal amountPaid, double discountPercentage) {
        return new Receipt(cart, amountPaid, discountPercentage, name);
    }


    public CustomerBill generateCustomerBill(Cart cart, double percentageDiscount) {
        return new CustomerBill(cart, percentageDiscount, name);
    }
}
