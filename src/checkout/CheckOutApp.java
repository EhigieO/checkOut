package checkout;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckOutApp {
    static Scanner scanner = new Scanner(System.in);
    private static Cart cart;
    private static Cashier cashier;

    public static void main(String[] args) {
        cashier = new Cashier(ask("What is your name? "));
        startCustomerShoppingExperience();

    }

    private static void startCustomerShoppingExperience() {
        String customerName = ask("What is the customer's Name");
        cart = new Cart(customerName);
        addNewItem();
        flushScanner();
        String response = ask("Do you have another customer? ");
        if (response.equalsIgnoreCase("yes")) startCustomerShoppingExperience();
        else exitApplication();
    }

    private static void exitApplication() {
        display("Thank you for using our service");
    }

    private static void addNewItem() {
        clearScreen();
        String itemName = ask("What did " + cart.getCustomerName() + " buy");
        int quantity = getIntResponseFor("How many pieces? ");
        BigDecimal unitPrice = getBigDecimalResponseFor("How much per unit? ");
        Item item = new Item(itemName, unitPrice, quantity);
        cart.addItems(item);
        flushScanner();
        String addMoreItem = ask("Add more Items from " + cart.getCustomerName() + "'s cart?");
        if (addMoreItem.equalsIgnoreCase("yes")) addNewItem();
        else checkCustomerOut();


    }

    private static void checkCustomerOut() {
        double percentageDiscount = getBigDecimalResponseFor("How much discount will he get (in percentage)").doubleValue();
        clearScreen();
        print(cashier.generateCustomerBill(cart, percentageDiscount));
        flushScanner();
        BigDecimal amountPaid = getBigDecimalResponseFor("How much did the customer give to you?");
        clearScreen();
        print(cashier.generateCustomerInvoice(cart, amountPaid, percentageDiscount));
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

    private static BigDecimal getBigDecimalResponseFor(String prompt) {
        try {
            display(prompt);
            return scanner.nextBigDecimal();
        } catch (InputMismatchException inputMismatchException) {
            display("Invalid input try again");
            clearScreen();
            return getBigDecimalResponseFor(prompt);
        }
    }

    private static int getIntResponseFor(String prompt) {
        try {
            display(prompt);
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            display("Invalid Input try again");
            clearScreen();
            return getIntResponseFor(prompt);
        }
    }

    private static String ask(String prompt) {
        display(prompt);
        return scanner.nextLine();
    }

    public static void display(String message) {
        System.out.println(message);
    }
}
