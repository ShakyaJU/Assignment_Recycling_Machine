public class ReceiptPrinter {
    public void print(ReceiptBasis receiptBasis) {
        System.out.println("===== Receipt =====");
        for (DepositItem item : receiptBasis.getItems()) {
            System.out.println(item.getType() + ": $" + item.getValue());
        }
        System.out.println("Total Refund: $" + receiptBasis.getTotalValue());
    }
}
