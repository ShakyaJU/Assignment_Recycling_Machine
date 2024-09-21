import java.util.Scanner;

public class DepositItemReceiver {
    private ReceiptBasis receiptBasis;
    private Scanner scanner;

    public DepositItemReceiver() {
        this.receiptBasis = new ReceiptBasis();
        this.scanner = new Scanner(System.in);
    }

    public void receiveItems(int cans, int bottles, int crates) {
        // Add cans
        for (int i = 0; i < cans; i++) {
            receiptBasis.addItem(new Can(i + 1));
        }
        // Add bottles
        for (int i = 0; i < bottles; i++) {
            receiptBasis.addItem(new Bottle(i + 1));
        }
        // Add crates
        for (int i = 0; i < crates; i++) {
            receiptBasis.addItem(new Crate(i + 1));
        }
    }

    public ReceiptBasis getReceiptBasis() {
        return receiptBasis;
    }
}
