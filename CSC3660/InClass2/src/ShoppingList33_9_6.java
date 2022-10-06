import java.util.ArrayList;

public class ShoppingList33_9_6 {
    ArrayList<Item> shoppingList = new ArrayList<>();

    public ShoppingList33_9_6(ArrayList<Item> shoppingList) {
        this.shoppingList = shoppingList;
    }
    public ShoppingList33_9_6(){

    }

    public void addItem(String name, int ct) {
        Item item = new Item(name, ct);
        shoppingList.add(item);
    }

    public void showList() {
        for(Item item : shoppingList){
            System.out.printf("\nName: %s Count: %s", item.getName(), item.getCount());
        }
    }

    public boolean removeItem(String name) {
        boolean gotIt = false;
        int ct = 0;
        for (Item item : shoppingList){
            if(item.getName().equals(name)){
                shoppingList.remove(ct);
                gotIt = true;
                break;
            }
            ct++;
        }
        return gotIt;
    }

    private class Item {
        private String name;
        private Integer count;

        public Item(String name, Integer count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "Item: " +
                    "name='" + name + '\'' +
                    ", count=" + count;
        }
    }
}
