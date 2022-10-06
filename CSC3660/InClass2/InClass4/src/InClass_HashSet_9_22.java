import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class InClass_HashSet_9_22 {
    public static void main(String[] args) {
//        HashSet<String> names = new HashSet<>();
        LinkedHashSet<String> names = new LinkedHashSet<>();
//        TreeSet<String> names = new TreeSet<>();
        names.add("Jack");
        names.add("Jill");
        names.add("Jane");
        names.add("James");
        names.add("Jack");

        System.out.printf("\nSize: %s", names.size());
        for(String name : names){
            System.out.printf("\nName: %s", name);
        }
        names.remove("Jill");
        if(names.contains("Jill")){
            System.out.printf("\nYep she's there");
        }
    }
}
