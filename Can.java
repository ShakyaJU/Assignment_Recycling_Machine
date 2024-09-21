class Can extends DepositItem {
    public Can(int id) {
        super(id, 0.25);  // Default value for a can
    }

    @Override
    public String getType() {
        return "Can";
    }
}