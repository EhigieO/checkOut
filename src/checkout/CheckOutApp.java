package checkout;

import java.math.BigDecimal;
import java.util.Scanner;

public class CheckOutApp {
    private static Cart cart;
    private static Cashier cashier;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        cashier = new Cashier(collectStringInput("What is your name? "));
        startCustomerShoppingExperience();

    }

    private static void startCustomerShoppingExperience() {
        String customerName = collectStringInput("What is the customer's Name");
        cart = new Cart(customerName);
        addNewItem();
        flushScanner();
        String response = collectStringInput("Do you have another customer? ");
        if(response.equalsIgnoreCase("yes")) startCustomerShoppingExperience();
        else exitApplication();
    }

    private static void exitApplication() {
        display("Thank you for using our service");
    }

    private static void addNewItem() {
        clearScreen();
        String itemName = collectStringInput("What did "+ cart.getCustomerName()+ " buy");
        int quantity = collectIntegerInput("How many pieces? ");
        BigDecimal unitPrice = collectBigDecimalInput("How much per unit? ");
        Item item = new Item(itemName, unitPrice, quantity);
        cart.addItems(item);
        flushScanner();
        String addMoreItem = collectStringInput("Add more Items from " + cart.getCustomerName()+"'s cart?");
        if(addMoreItem.equalsIgnoreCase("yes")) addNewItem();
        else checkCustomerOut();


    }

    private static void checkCustomerOut() {
        double percentageDiscount = collectBigDecimalInput("How much discount will he get (in percentage)").doubleValue();
        clearScreen();
        print(cashier.generateCustomerBill(cart, percentageDiscount));
        flushScanner();
        BigDecimal amountPaid = collectBigDecimalInput("How much did the customer give to you?");
        clearScreen();
        print(cashier.generateCustomerInvoice(cart, amountPaid,percentageDiscount));
    }

    private static void clearScreen() {
        display("\n".repeat(50));
    }

    private static void flushScanner() {
        scanner.nextLine();
    }

    private static void print(Printable printable) {
        printable.print();
    }

    private static BigDecimal collectBigDecimalInput(String prompt) {
        display(prompt);
        return scanner.nextBigDecimal();
    }

    private static int collectIntegerInput(String prompt) {
        display(prompt);
        return scanner.nextInt();
    }

    private static String collectStringInput(String prompt) {
        display(prompt);
        return scanner.nextLine();
    }
    public static void display(String message){
        System.out.println(message);
    }
}
