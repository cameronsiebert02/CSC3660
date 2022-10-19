package TruckHW;

import lib.FileIOV2;

import java.util.*;

public class TruckManager {
    public static void main(String[] args) {
        String inFile = "/Users/cameronsiebert/Documents/GitHub/CSC3660/CSC3660/InClass7/src/TruckHW/TruckOrder.txt";
        HashMap<Integer, String> HMData = new HashMap<>();
        ArrayList<String> data = getFileData(inFile);
        Deque<String> data2 = getDeque(data);
        showTrucks(data2, HMData);
        int uIn = getUserInput(HMData);
    }

    private static int getUserInput(HashMap<Integer, String> tIDs) {
        Scanner scan = new Scanner(System.in);
        Set<Integer> keys = tIDs.keySet();
        System.out.printf("\nEnter truck to remove[(%s)]: ", keys);
        int uIn = 0;
        try{
            uIn = scan.nextInt();
            if(keys.contains(uIn)){
                return uIn;
            } else {
                System.out.printf("\nNot a valid input, please enter a number in range %s: ", keys);
                uIn = scan.nextInt();
            }
        }catch (Exception e){
            System.out.printf("\nPlease enter an integer value.");
            System.out.printf("\nNot a valid input, please enter a number in range %s: ", keys);
            uIn = scan.nextInt();
        }
        return uIn;
    }

    private static Deque<String> getDeque(ArrayList<String> data) {
        Deque<String> reformdata = new ArrayDeque<>();
        for(int i = 1; i < data.size(); i++){
            reformdata.push(data.get(i));
        }
        return reformdata;
    }

    private static void showTrucks(Deque<String> data, HashMap<Integer, String> tIDs) {
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

    private static ArrayList<String> getFileData(String inFile) {
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
