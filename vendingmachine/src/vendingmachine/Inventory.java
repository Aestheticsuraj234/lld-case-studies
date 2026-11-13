package vendingmachine;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Slot> slots = new LinkedHashMap<>();

    public void addSlot(String code, Product p, int qty) {
        slots.put(code, new Slot(code, p, qty));
    }

    // Returns null for an unknown code.
    public Slot getSlot(String code) {
        return slots.get(code);
    }

    public void print() {
        for (Slot slot : slots.values()) {
            Product p = slot.getProduct();
            String stock = slot.isEmpty() ? "SOLD OUT" : "qty " + slot.getQuantity();
            System.out.println(slot.getCode() + ": " + p.getName() + " - " + p.getPrice() + " (" + stock + ")");
        }
    }
}
