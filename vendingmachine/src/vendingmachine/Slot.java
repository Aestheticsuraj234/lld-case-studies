package vendingmachine;

public class Slot {
    private final String code;
    private final Product product;
    private int quantity;

    public Slot(String code, Product product, int quantity) {
        this.code = code;
        this.product = product;
        this.quantity = quantity;
    }

    public boolean isEmpty() {
        return quantity == 0;
    }

    public void reduceQuantity() {
        if (isEmpty()) {
            throw new IllegalStateException("Slot " + code + " is empty");
        }
        quantity--;
    }

    public String getCode() {
        return code;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
