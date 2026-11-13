package vendingmachine;

public class IdleState implements State {
    @Override
    public void insertCoin(VendingMachine m, Coin coin) {
        m.addBalance(coin.getValue());
        System.out.println("Inserted " + coin.getValue() + ". Balance: " + m.getBalance());
        m.setState(VendingMachine.HAS_MONEY);
    }

    @Override
    public void selectProduct(VendingMachine m, String code) {
        System.out.println("Insert money first.");
    }

    @Override
    public void cancel(VendingMachine m) {
        System.out.println("Nothing to cancel.");
    }
}
