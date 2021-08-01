package checkout;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    void items_canBeCreatedWithDetails(){
        Item item = new Item("Omo Detergent", BigDecimal.valueOf(50), 2);
        assertAll("Items can be created via constructor",
                ()-> assertEquals("Omo Detergent",item.getProductName()),
                () -> assertEquals(BigDecimal.valueOf(50), item.getProductPrice()),
                () -> assertEquals(2, item.getQuantityPurchased())
        );

    }

    @Test
    void items_canCalculateTotalPrice(){
        Item item = new Item("Omo Detergent", BigDecimal.valueOf(50), 2);
        assertEquals(BigDecimal.valueOf(100), item.calculatePrice());
    }

    @Test
    void items_canRenderToStringCorrectly(){
        Item item = new Item("Omo Detergent", BigDecimal.valueOf(50), 2);
        Formatter formatter = new Formatter();
        String expectedToString = String.format("%25s    %3d  %8.2f     %8.2f", formatter.format("Omo Detergent"), 2, 50.00, 100.00);
        assertEquals(expectedToString, item.toString());
    }


}

