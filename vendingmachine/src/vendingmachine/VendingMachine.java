package vendingmachine;

public class VendingMachine {
    // States hold no data of their own, so one shared instance of each is enough.
    static final State IDLE = new IdleState();
    static final State HAS_MONEY = new HasMoneyState();

    private final Inventory inventory;
    private State state = IDLE;
    private int balance;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
    }

    public void insertCoin(Coin coin) {
        state.insertCoin(this, coin);
    }

    public void selectProduct(String code) {
        state.selectProduct(this, code);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void showProducts() {
        inventory.print();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getBalance() {
        return balance;
    }

    // Package-private: only the states should change balance and state.
    void addBalance(int amount) {
        balance += amount;
    }

    void resetBalance() {
        balance = 0;
    }

    void setState(State state) {
        this.state = state;
    }
}
