import java.util.Iterator;
import java.util.Stack;

public class InClass_10_6_Stack {
    public static void main(String[] args) {
        Stack<String> myShopList = new Stack<>();       // Two operations: Push and Pop
        myShopList.push("Apple");
        myShopList.push("Banana");
        myShopList.push("Cake");
        myShopList.push("Donut");
        String top = myShopList.pop();
        System.out.printf("\nTop: %s", top);
        System.out.printf("\nSize: %s", myShopList.size());
        myShopList.push("Eggs");
        System.out.printf("\nPeek Top: %s", myShopList.peek());
        System.out.printf("\nSize: %s", myShopList.size());
        showStack(myShopList);
    }

    private static void showStack(Stack<String> myShopList) {
        System.out.printf("\n-----------------------");
//        for (String item: myShopList){
//            System.out.printf("\nItem: %s", item);
//        }
        Iterator value = myShopList.iterator();
        // Displaying the values
        // after iterating through the stack
        System.out.println("The iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }
    }
}
