package checkout;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CashierTest {

    @Test
    void cashier_canPrintInvoiceTest() {
        Cashier cashier = new Cashier("Blessing");
        Cart cart = new Cart("Ojo");
        Item item1 = new Item("Agege Bread", BigDecimal.valueOf(250), 2);
        Item item2 = new Item("Sniper", BigDecimal.valueOf(500), 2);
        cart.add(item1);
        cart.add(item2);

        cashier.generateCustomerReceipt(cart, BigDecimal.valueOf(7500), 45).print();
    }


}
