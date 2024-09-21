class Crate extends DepositItem {
    public Crate(int id) {
        super(id, 1.00);  // Default value for a crate
    }

    @Override
    public String getType() {
        return "Crate";
    }
}