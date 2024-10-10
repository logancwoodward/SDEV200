package StoreTransaction.Items;

public class ItemTest {
    public static void main(String[] args) {
        //create instances of FoodItem and NonFoodItem
        Item apple = new FoodItem("Apple", 0.99);
        Item soap = new NonFoodItem("Soap", 2.49);

        //test the getName(), getPrice(), and getTotalPrice() methods
        System.out.println("Testing Item class...");

        System.out.println("Item 1: " + apple.getName() + " - Price: $" + apple.getPrice() + " - Total: $" + apple.getTotalPrice());
        System.out.println("Item 2: " + soap.getName() + " - Price: $" + soap.getPrice() + " - Total: $" + soap.getTotalPrice());

        //verify that the values are as expected
        assert apple.getName().equals("Apple") : "Item 1 name should be 'Apple'";
        assert apple.getPrice() == 0.99 : "Item 1 price should be 0.99";
        assert apple.getTotalPrice() == 0.99 : "Apple should have no tax";

        assert soap.getName().equals("Soap") : "Item 2 name should be 'Soap'";
        assert soap.getPrice() == 2.49 : "Item 2 price should be 2.49";
        assert soap.getTotalPrice() == 2.49 * 1.07 : "Soap should include 7% tax";

        System.out.println("All tests passed!");
    }
}
