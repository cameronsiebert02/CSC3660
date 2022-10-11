import java.util.*;

public class InClass_10_11 {
    public static void main(String[] args) {
        Deque<String> myD = new ArrayDeque<>();
        Deque<String> myD2 = new LinkedList<>();
        HashMap<String, ArrayList<Auto>> autos = new HashMap<>();
        Auto newAuto = new Auto("Chevy", "Accord", "Good", "Goos", "Blue");
        String deleteThese = "Red";
        String a = "Chevy";
        if(autos.containsKey(a)){
            ArrayList<Auto> chevies = autos.get(a);
            ArrayList<Auto> newChevies = deleteThisColor(deleteThese, chevies);
            autos.put(a, newChevies);
        }

        // add new chevy
        if(autos.containsKey(a)){
            ArrayList<Auto> chevies = autos.get(a);
            chevies.add(newAuto);
            autos.put(a, chevies);
        }
        for(int i = 0; i < autos.size(); i++){
            System.out.printf("\nBlah");
        }
    }

    private static ArrayList<Auto> deleteThisColor(String deleteThese, ArrayList<Auto> chevies) {
        ArrayList<Auto> noRed = new ArrayList<>();
        for(Auto auto : chevies){
            if(!auto.getColor().equalsIgnoreCase(deleteThese)){
                noRed.add(auto);
            }
        }
        return noRed;
    }
}
