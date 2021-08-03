package checkout;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    void cart_canBeCreatedTest() {
        Cart cart = new Cart("Joshua");
        assertNotNull(cart);
    }

    @Test
    void items_canBeAddedToCartTest() {
        Cart cart = new Cart("Ojo");
        Item item1 = new Item("Agege Bread", BigDecimal.valueOf(230), 3);
        Item item2 = new Item("Sniper", BigDecimal.valueOf(850), 9);
        cart.add(item1);
        cart.add(item2);
        assertAll("Items can be added to cart",
                () -> assertEquals(12, cart.getTotalProductsInCart()),
                () -> assertEquals(2, cart.getTotalItems())
        );
    }

    @Test
    void cart_canCalculateTotalPriceOfItemsTest() {
        Cart cart = new Cart("Ojo");
        Item item1 = new Item("Agege Bread", BigDecimal.valueOf(250), 2);
        Item item2 = new Item("Sniper", BigDecimal.valueOf(500), 2);
        cart.add(item1);
        cart.add(item2);
        assertAll("Items can be added to cart",
                () -> assertEquals(4, cart.getTotalProductsInCart()),
                () -> assertEquals(2, cart.getTotalItems()),
                () -> assertEquals(BigDecimal.valueOf(1500), cart.calculateTotalPriceOfItems())
        );
    }

    @Test
    void cart_canBeViewed() {
        Cart cart = new Cart("Ojo");
        Item item1 = new Item("Agege Bread", BigDecimal.valueOf(250), 2);
        Item item2 = new Item("Sniper", BigDecimal.valueOf(500), 2);
        cart.add(item1);
        cart.add(item2);
        Formatter formatter = new Formatter();
        Formatter formatter1 = new Formatter();
        String expectedToString = String.format("%15s    %3d  %8.2f     %8.2f%n%15s    %3d  %8.2f     %8.2f", formatter.format("Agege Bread"), 2, 250.00, 500.00, formatter1.format("Sniper"), 2, 500.00, 1000.00);
        assertEquals(expectedToString, cart.toString());
        System.out.println(cart);

    }
}
