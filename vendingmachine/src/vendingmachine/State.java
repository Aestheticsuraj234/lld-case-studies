package vendingmachine;

public interface State {
    void insertCoin(VendingMachine m, Coin coin);

    void selectProduct(VendingMachine m, String code);

    void cancel(VendingMachine m);
}
