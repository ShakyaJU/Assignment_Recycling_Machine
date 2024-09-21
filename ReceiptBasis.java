import java.util.ArrayList;

public class ReceiptBasis {
    private ArrayList<DepositItem> items;

    public ReceiptBasis() {
        items = new ArrayList<>();
    }

    public void addItem(DepositItem item) {
        items.add(item);
    }

    public double getTotalValue() {
        double total = 0;
        for (DepositItem item : items) {
            total += item.getValue();
        }
        return total;
    }

    public ArrayList<DepositItem> getItems() {
        return items;
    }
}
