package vendingmachine;

public class HasMoneyState implements State {
    @Override
    public void insertCoin(VendingMachine m, Coin coin) {
        m.addBalance(coin.getValue());
        System.out.println("Inserted " + coin.getValue() + ". Balance: " + m.getBalance());
    }

    @Override
    public void selectProduct(VendingMachine m, String code) {
        Slot slot = m.getInventory().getSlot(code);
        if (slot == null) {
            System.out.println("Invalid code: " + code);
            return;
        }
        if (slot.isEmpty()) {
            System.out.println(slot.getProduct().getName() + " is sold out.");
            return;
        }

        int price = slot.getProduct().getPrice();
        int balance = m.getBalance();
        if (balance < price) {
            System.out.println("Not enough money. Price: " + price + ", balance: " + balance);
            return;
        }

        slot.reduceQuantity();
        System.out.println("Dispensed " + slot.getProduct().getName() + ". Change: " + (balance - price));
        m.resetBalance();
        m.setState(VendingMachine.IDLE);
    }

    @Override
    public void cancel(VendingMachine m) {
        System.out.println("Returned " + m.getBalance());
        m.resetBalance();
        m.setState(VendingMachine.IDLE);
    }
}
