package vendingmachine;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addSlot("A1", new Product("Chips", 15), 2);
        inventory.addSlot("A2", new Product("Soda", 25), 1);
        inventory.addSlot("B1", new Product("Candy", 10), 0);

        VendingMachine vm = new VendingMachine(inventory);
        vm.showProducts();

        System.out.println("\n-- Buy chips with 20 --");
        vm.insertCoin(Coin.TWENTY);
        vm.selectProduct("A1");

        System.out.println("\n-- Select while idle --");
        vm.selectProduct("A1");

        System.out.println("\n-- Not enough, then top up --");
        vm.insertCoin(Coin.TEN);
        vm.selectProduct("A2");
        vm.insertCoin(Coin.TWENTY);
        vm.selectProduct("A2");

        System.out.println("\n-- Sold out, wrong code, cancel --");
        vm.insertCoin(Coin.FIVE);
        vm.insertCoin(Coin.FIVE);
        vm.selectProduct("B1");
        vm.selectProduct("Z9");
        vm.cancel();

        System.out.println();
        vm.showProducts();
    }
}
