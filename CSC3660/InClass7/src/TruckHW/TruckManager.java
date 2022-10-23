package TruckHW;

import lib.FileIOV2;

import java.util.*;

public class TruckManager {
    public static void main(String[] args) {
        String inFile = "/Users/cameronsiebert/Documents/GitHub/CSC3660/CSC3660/InClass7/src/TruckHW/TruckOrder.txt";
        HashMap<Integer, String> HMData = new HashMap<>();
        ArrayList<String> data = getFileData(inFile);
        Deque<String> data2 = getDeque(data);
        boolean go = true;
        while (go){
            showTrucks(data2, HMData);
            String uIn = getUserInput(HMData);
            removeTruck(uIn, data2, HMData);
        }
    }

    public static void removeTruck(String uIn, Deque<String> data2, HashMap<Integer, String> HMData) {
        System.out.printf("\nYou must remove these truck(s) first: ");
        System.out.printf("\n-----Showing truck(s) you must remove first-----");
        for(String row : data2){
            String[] toks = row.split(",");
            int truckID = Integer.parseInt(toks[0]);
            int zip = Integer.parseInt(toks[1]);
            int packages = Integer.parseInt(toks[2]);
            if(truckID == Integer.parseInt(uIn)){
                data2.remove(row);
                removeFromHM(HMData, uIn);
                break;
            }
            System.out.printf("\nTruckID: %s Zip: %s Number of Packages: %s", truckID, zip, packages);
        }
    }

    private static void removeFromHM(HashMap<Integer, String> hmData, String uIn) {
        TreeSet<Integer> keys = new TreeSet<>(hmData.keySet());
        for (Integer key : keys){
            if(Integer.parseInt(uIn) == key){
                hmData.remove(key);
            }
        }
    }

    public static String getUserInput(HashMap<Integer, String> tIDs) {
        Scanner scan = new Scanner(System.in);
        TreeSet<Integer> keys = new TreeSet<>(tIDs.keySet());
        System.out.printf("\nEnter truck to remove[(%s)]: ", keys);
        String uIn = "";
        try{
            uIn = scan.nextLine();
            if(keys.contains(Integer.parseInt(uIn))){
                return uIn;
            } else {
                System.out.printf("\nNot a valid input, please enter a number in range %s: ", keys);
                uIn = scan.nextLine();
            }
        }catch (Exception e){
            if (uIn.equalsIgnoreCase("Q")){
                System.exit(1);
            }
            System.out.printf("\nPlease enter an integer value.");
            uIn = getUserInput(tIDs);
        }
        return uIn;
    }

    public static Deque<String> getDeque(ArrayList<String> data) {
        Deque<String> reformdata = new ArrayDeque<>();
        for(int i = 1; i < data.size(); i++){
            reformdata.push(data.get(i));
        }
        return reformdata;
    }

    public static void showTrucks(Deque<String> data, HashMap<Integer, String> tIDs) {
        System.out.printf("\n------Showing the current alley of trucks------");
        for(String row : data){
            String[] toks = row.split(",");
            int truckID = Integer.parseInt(toks[0]);
            int zip = Integer.parseInt(toks[1]);
            int packages = Integer.parseInt(toks[2]);
            System.out.printf("\nTruckID: %s Zip: %s Number of Packages: %s", truckID, zip, packages);
            String rest = toks[1] + toks[2];
            tIDs.put(truckID, rest);
        }
    }

    public static ArrayList<String> getFileData(String inFile) {
        FileIOV2 fio = new FileIOV2(inFile);
        try {
            fio.setFileData();
        }catch (Exception e){
            System.out.printf("\nfName: %s problem", inFile);
            System.out.printf("\nException: %s", e.getMessage());
            System.exit(1);
        }
        return fio.getFileData();
    }
}