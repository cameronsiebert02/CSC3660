import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class InClass_9_27_Hash {
    public static void main(String[] args) {
        HashSet<Integer> myNums = new HashSet<>();
        HashSet<Double> prices = new HashSet<>();
        HashSet<String> names = new HashSet<>();

        TreeSet<String> myOtherNames = new TreeSet<>();
        LinkedHashSet<String> myLinkers = new LinkedHashSet<>();

        myNums.add(22);
        myNums.add(44);
        myNums.add(1);
        myNums.remove(44);
        if (myNums.contains(44)){
            System.out.printf("\n Yes we got 44!");
        }else {
            System.out.printf("\n No got it!");
        }
        for (int n : myNums){
            System.out.printf("\n n: %s", n);
        }
    }
}
