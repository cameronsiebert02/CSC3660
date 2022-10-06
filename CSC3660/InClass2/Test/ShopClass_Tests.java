import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopClass_Tests {
    @Test
    public void creationTest(){
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 12, false));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
        assertEquals(1, sl.getSize());
    }

    @Test
    public void addItemTest(){
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, false));
        shoppingList.add(new Item("Chicken", 4, false));
        shoppingList.add(new Item("Pizza", 6, false));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
        sl.removeItem("Chicken");
        assertEquals(2, sl.getSize());
    }
    @Test
    public void nameIsThereTest(){
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, false));
        shoppingList.add(new Item("Chicken", 4, false));
        shoppingList.add(new Item("Pizza", 6, false));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
        assertEquals(1, sl.isNameThere("Chicken"));
    }
    @Test
    public void nameIsThereTest1(){
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, false));
        shoppingList.add(new Item("Chicken", 4, false));
        shoppingList.add(new Item("Pizza", 6,false));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
        assertEquals(-1, sl.isNameThere("Blah"));
    }
    @Test
    public void renameItemTest(){
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, false));
        shoppingList.add(new Item("Chicken", 4, false));
        shoppingList.add(new Item("Pizza", 6,true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
        assertEquals(true, sl.renameItem("Chicken", "Beef"));
    }
    @Test
    public void getItemsTest(){
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, true));
        shoppingList.add(new Item("Chicken", 4, false));
        shoppingList.add(new Item("Pizza", 6,true));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
        assertEquals(2, sl.getItems(true).size());
    }
    @Test
    public void renameItemFailTest(){
        ArrayList<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("Banana", 2, false));
        shoppingList.add(new Item("Chicken", 4, true));
        shoppingList.add(new Item("Pizza", 6,false));
        ShoppingList_9_6 sl = new ShoppingList_9_6(shoppingList);
        assertEquals(false, sl.renameItem("Apple", "Grape"));
    }
}
