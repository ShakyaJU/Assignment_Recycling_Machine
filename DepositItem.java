public abstract class DepositItem {
    protected int id;
    protected double value;

    public DepositItem(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public abstract String getType(); // Each subclass will implement its own type
}
