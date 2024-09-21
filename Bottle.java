class Bottle extends DepositItem {
    public Bottle(int id) {
        super(id, 0.50);  // Default value for a bottle
    }

    @Override
    public String getType() {
        return "Bottle";
    }
}