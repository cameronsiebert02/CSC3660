import java.util.ArrayList;

public class ShoppingList_9_6 {
    ArrayList<Item> shoppingList = new ArrayList<>();

    public ShoppingList_9_6(ArrayList<Item> shoppingList) {
        this.shoppingList = shoppingList;
    }
    public ShoppingList_9_6(){

    }
    public void addItem(String name, int ct) {
        // Change to if item exists, then change count to ct
        int theItemIdx = isNameThere(name);
        if(theItemIdx != -1){
            shoppingList.remove(theItemIdx);
            shoppingList.add(new Item(name, ct, false));
        }else {
            shoppingList.add(new Item(name, ct, false));
        }
    }

    public int isNameThere(String inName) {
        int theItemInx = -1;
        int count = 0;
        for(Item item : shoppingList){                      // Big O = O(n) is all the times you could loop in total
            if(item.getName().equals(inName)){
                theItemInx = count;
                break;
            }
            count++;
        }
        return theItemInx;
    }

    public void showList() {
        for ( Item item : shoppingList){
            System.out.printf("\nItem:%s Ct:%s", item.getName(),
                    item.getCt());
        }
    }
    public int getSize(){
        return shoppingList.size();
    }
    public boolean removeItem(String inItem) {
        boolean gotIt = false;
        int ct = 0;
        for ( Item item : shoppingList){
            if ( item.getName().equals(inItem)){
                shoppingList.remove(ct);
                gotIt = true;
                break;
            }
            ct++;
        }
        return gotIt;
    }
    public ArrayList<Item> getItems(boolean gotIt) {
        ArrayList<Item> gotThem = new ArrayList<>();
        // Todo: return an ArrayList of item that
        //      match the gotIt true or false value.
        //      For example if set to True, then return
        //      an ArrayList of Item with .
        for(Item item : shoppingList){
            if(item.getGotIt() == gotIt){
                gotThem.add(item);
            }
        }
        return gotThem;
    }
    public boolean renameItem ( String origName, String newName ){
        //ToDo: Find an item name origName and change its name to newName
        // If found then return true
        // If not found return false
        for(Item item : shoppingList){
            if(item.getName().equals(origName)){
                item.setName(newName);
                return true;
            }
        }
        return false;
    }
}
class Item {
    private String name;
    private int ct;
    // ToDo: Add this attribute with getters ,setters
    //        and toString updated
    // ToDo: Adjust the constructor of Shopping list and
    //        make sure it works right
    private boolean gotIt;

    public Item(String name, int ct, boolean gotit) {
        this.name = name;
        this.ct = ct;
        this.gotIt = gotit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCt() {
        return ct;
    }
    public void setCt(int ct) {
        this.ct = ct;
    }

    public boolean getGotIt() {
        return gotIt;
    }

    public void setGotIt(boolean gotIt) {
        this.gotIt = gotIt;
    }

    @Override
    public String toString() {
        return "Item name: " + name +
                " ct: " + ct + " gotIt: " + gotIt;
    }
}
