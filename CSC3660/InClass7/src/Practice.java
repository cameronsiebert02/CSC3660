import java.util.HashMap;

public class Practice {
    public static void main(String[] args) {
        HashMap<String, Integer> something = new HashMap<>();
        something.put("One", 1);
        something.put("Two", 2);
        something.put("Three", 3);
        for (String key : something.keySet()){
            System.out.printf("\nNum: %s", something.get(key));
        }
    }
}
