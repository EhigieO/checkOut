package checkout;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final String ownerName;
    private final List<Item> items = new ArrayList<>();

    public Cart(String ownerName) {
        this.ownerName = ownerName;
    }

    public void addItems(Item item) {
        items.add(item);
    }

    public int getTotalProductsInCart() {
        int total = 0;
        for (Item item: items){
            total+=item.getQuantityPurchased();
        }
        return total;
    }

    public int getTotalItems() {
        return items.size();
    }

    public BigDecimal calculateTotalPriceOfItems() {
        BigDecimal total = BigDecimal.ZERO;
        for(Item item: items){
          total =total.add(item.calculatePrice());
        }
        return total;
    }

    public String toString(){
        StringBuilder toString= new StringBuilder();
        for(Item item: items){
            toString.append(item.toString()).append("\n");
        }
        return toString.substring(0,toString.length()-1);
    }

    public String getCustomerName() {
        return ownerName;
    }
}
