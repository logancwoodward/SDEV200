package StoreTransaction;
public class ItemTest {
    public static void main(String[] args) {
        //create instances of Item
        Item item1 = new Item("Apple", 0.99);
        Item item2 = new Item("Banana", 1.29);
        Item item3 = new Item("Orange", 0.79);
        
        //test the getName() and getPrice() methods
        System.out.println("Testing Item class...");
        
        System.out.println("Item 1: " + item1.getName() + " - Price: $" + item1.getPrice());
        System.out.println("Item 2: " + item2.getName() + " - Price: $" + item2.getPrice());
        System.out.println("Item 3: " + item3.getName() + " - Price: $" + item3.getPrice());
        
        //verify that the values are as expected
        assert item1.getName().equals("Apple") : "Item 1 name should be 'Apple'";
        assert item1.getPrice() == 0.99 : "Item 1 price should be 0.99";
        
        assert item2.getName().equals("Banana") : "Item 2 name should be 'Banana'";
        assert item2.getPrice() == 1.29 : "Item 2 price should be 1.29";
        
        assert item3.getName().equals("Orange") : "Item 3 name should be 'Orange'";
        assert item3.getPrice() == 0.79 : "Item 3 price should be 0.79";
        
        System.out.println("All tests passed!");
    }
}