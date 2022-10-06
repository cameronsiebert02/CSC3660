public class InClass_Shopping_9_6 {
    public static void main(String[] args) {
        ShoppingList33_9_6 sl = new ShoppingList33_9_6();
        sl.addItem("Banana", 6);
        sl.addItem("Coconut", 2);
        sl.addItem("Apple", 12);
//        sl.shoppingList.add(new ShoppingList33_9_6.Item("Hot Dog", 4));
        sl.showList();
        sl.removeItem("Coconut");
    }
}
