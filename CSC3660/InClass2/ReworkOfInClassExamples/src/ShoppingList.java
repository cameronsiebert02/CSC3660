import java.util.ArrayList;

public class ShoppingList {
    public static void main(String[] args) {
        ArrayList<Item> sList = new ArrayList<>();
        addItems(sList);
        showItems(sList);
        int totalItems = getTotalItems(sList);
        System.out.printf("\nTotal items: %s", totalItems);
        showOnlyItems(sList);
    }

    private static void showOnlyItems(ArrayList<Item> sList) {
        int count = 1;
        for (Item item : sList){
            System.out.printf("\nItem #%s: %s", count, item.getName());
            count++;
        }
    }

    private static int getTotalItems(ArrayList<Item> sList) {
        int total = 0;
        for (Item item : sList){
            total += item.getCount();
        }
        return total;
    }

    private static void showItems(ArrayList<Item> sList) {
        for(Item item : sList){
//            System.out.printf("\nItem: %s Amount: %s", item.getName(), item.getCount());
            System.out.printf(item.toString());
        }
    }

    private static void addItems(ArrayList<Item> sList) {
        sList.add(new Item("Banana", 3));
        sList.add(new Item("Apple", 13));
        sList.add(new Item("Grapes", 1));
    }
}
