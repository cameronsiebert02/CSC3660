import java.util.TreeMap;
import java.util.HashSet;
import java.util.Set;

public class InClassHashMap_9_27 {
    public static void main(String[] args) {
        TreeMap<String, Double> prices = new TreeMap<>();
        prices.put("Apples", 16.99);
        prices.put("Bananas", 12.99);
        prices.put("Hot Dogs", 15.99);

        if(prices.containsKey("Apples")){
            System.out.printf("\nYes we have apples at: %s", prices.get("Apples"));
        }else{
            System.out.printf("\nNot got apples");
        }
        Set<String> myKeys = prices.keySet();
        for(String key : prices.keySet()){
            Double price = prices.get(key);
            System.out.printf("\nItem: %s Price: %s", key, price);
        }
        // Price increase on Bananas
        // prices.replace("Bananas", 15.99);
        Double p = prices.get("Bananas")+ 3;
        prices.put("Bananas", p);
        for(String key : prices.keySet()){
            Double price = prices.get(key);
            System.out.printf("\nItem: %s Price: %s", key, price);
        }

        TreeMap<Integer, String> parts = new TreeMap<>();
        parts.put(1234, "Hammer");
        parts.put(3333, "Saw");
        parts.put(4444, "Wrench");
    }
}
