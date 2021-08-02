package checkout;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CashierTest {

    @Test
    void cashier_canPrintInvoiceTest() {
        Cashier cashier = new Cashier(System.getenv().get("userName"));
        Cart cart = new Cart("Ojo");
        Item item1 = new Item("Agege Bread", BigDecimal.valueOf(250), 2);
        Item item2 = new Item("Sniper", BigDecimal.valueOf(500), 2);
        cart.addItems(item1);
        cart.addItems(item2);

        cashier.generateCustomerInvoice(cart, BigDecimal.valueOf(7500), 45).print();
    }


}
