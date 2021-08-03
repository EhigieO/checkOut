package checkout;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Printable {


    static String generateCustomerReceipt(Cart cart, BigDecimal amountPaid, double discountPercentage, String cashierName) {
        return generateCompanyInvoiceHeader(cart.getCustomerName(), cashierName) + "\n" + cart + "\n" + generateInvoiceFooter(cart, amountPaid, discountPercentage);

    }

    private static String generateCompanyInvoiceHeader(String customerName, String cashierName) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy h:mm:ss a");
        String formattedDateAndTime = LocalDateTime.now().format(dateTimeFormatter);

        return String.format("""
                SEMICOLON STORES
                MAIN BRANCH
                LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
                TEL: 0808-123-5670
                Date : %s
                Cashier: %s
                Customer Name: %s
                ==========================================================
                                     ITEM    QTY    PRICE      TOTAL(NGN)
                ----------------------------------------------------------""", formattedDateAndTime, cashierName, customerName);
    }

    static String generateInvoiceFooter(Cart cart, BigDecimal amountPaid, double discountPercentage) {

        BigDecimal total = cart.calculateTotalPriceOfItems();
        BigDecimal discountAmount = calculatePercentageAmount(total, (discountPercentage) / 100);
        BigDecimal vatAtSevenPointFivePercent = calculatePercentageAmount(total, 0.175);
        BigDecimal billTotal = calculateCustomerBillTotal(total, discountAmount, vatAtSevenPointFivePercent);
        BigDecimal balance = amountPaid.subtract(billTotal);
        if (balance.doubleValue() < 0.0) {
            throw new IllegalArgumentException("Pay up your bill");
        }


        return String.format("""
                ----------------------------------------------------------
                                                  Sub Total:     %5.2f
                                                   Discount:      %5.2f
                                               VAT @ 17.50%%:      %5.2f
                ==========================================================
                                                 Bill Total:     %5.2f
                                                Amount Paid:     %5.2f
                                                    Balance:      %5.2f
                ==========================================================
                              THANK YOU FOR YOUR PATRONAGE
                ==========================================================
                                     
                """, total, discountAmount, vatAtSevenPointFivePercent, billTotal, amountPaid, balance);
    }

    static String displayCustomerBill(Cart cart, double percentageDiscount, String cashierName) {
        return generateCompanyInvoiceHeader(cart.getCustomerName(), cashierName) + "\n" + cart + "\n" + generateInvoiceFooter(cart, percentageDiscount);
    }

    private static String generateInvoiceFooter(Cart cart, double percentageDiscount) {
        BigDecimal total = cart.calculateTotalPriceOfItems();
        BigDecimal discountAmount = calculatePercentageAmount(total, (percentageDiscount) / 100);
        BigDecimal vatAtSevenPointFivePercent = calculatePercentageAmount(total, 0.175);
        BigDecimal billTotal = calculateCustomerBillTotal(total, discountAmount, vatAtSevenPointFivePercent);

        return String.format("""
                ----------------------------------------------------------
                                                  Sub Total:     %5.2f
                                                   Discount:      %5.2f
                                               VAT @ 17.50%%:      %5.2f
                ==========================================================
                                                 Bill Total:     %5.2f
                ==========================================================
                                 THIS IS NOT A RECEIPT
                               KINDLY ACCEPT TO PAY %.2f
                ==========================================================
                                     
                """, total, discountAmount, vatAtSevenPointFivePercent, billTotal, billTotal);
    }


    private static BigDecimal calculateCustomerBillTotal(BigDecimal total, BigDecimal discountAmount, BigDecimal vat) {
        return vat.add(total).subtract(discountAmount);
    }

    private static BigDecimal calculatePercentageAmount(BigDecimal total, double percentageValue) {
        return total.multiply(BigDecimal.valueOf(percentageValue));
    }

    void print();


}
