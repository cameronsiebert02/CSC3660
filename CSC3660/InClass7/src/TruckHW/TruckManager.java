package TruckHW;

import lib.FileIOV2;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TruckManager {
    public static void main(String[] args) {
        String inFile = "/Users/cameronsiebert/Documents/GitHub/CSC3660/CSC3660/InClass7/src/TruckHW/TruckOrder.txt";
        ArrayList<String> data = getFileData(inFile);
        showTrucks(data);
    }

    private static void showTrucks(ArrayList<String> data) {
        boolean firstLine = true;
        for(String row : data){
            if(firstLine){
                firstLine = false;
                continue;
            }
            String[] toks = row.split(",");
            int truckID = Integer.parseInt(toks[0]);
            int zip = Integer.parseInt(toks[1]);
            int packages = Integer.parseInt(toks[2]);
            System.out.printf("\nTruckID: %s Zip: %s Number of Packages: %s", truckID, zip, packages);
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
