public class InClass_Shopping2_9_6 {
    public static void main(String[] args) {
        ShoppingList_9_6 sl = new ShoppingList_9_6();
        sl.addItem( "Banana", 6);
        sl.addItem("Coconut", 2);
        sl.addItem("Apple", 12);
        //sl.shoppingList.add(new sl.shoppingList.Item("Hot Dog", 22));
        sl.showList();
        sl.removeItem("Coconut");
        Item item = new Item("Baseball", 12, false);

    }
}
