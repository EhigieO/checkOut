package checkout;

public class CustomerBill implements Printable {
    private final String customerBill;
    public CustomerBill(Cart cart, double percentageDiscount, String cashierName) {
        customerBill = Printable.displayCustomerBill(cart,percentageDiscount,cashierName);

    }

    @Override
    public void print() {
        System.out.println(customerBill);
    }
}
