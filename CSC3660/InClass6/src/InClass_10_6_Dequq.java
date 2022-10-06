import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class InClass_10_6_Dequq {
    public static void main(String[] args) {
//        Stack<String> myShopList = new Stack<>();       // Two operations: Push and Pop
        Deque<String> myShopList = new ArrayDeque<>();
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

    private static void showStack(Deque<String> myShopList) {
        System.out.printf("\n-----------------------");
//        for (String item: myShopList){
//            System.out.printf("\nItem: %s", item);
//        }
        Iterator value = myShopList.iterator();
        // Displaying the values
        // after iterating through the stack
        System.out.println("\nThe iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }
    }
}
