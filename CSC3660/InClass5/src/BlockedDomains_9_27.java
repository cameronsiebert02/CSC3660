import lib.FileIOV2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class BlockedDomains_9_27 {
    public static void main(String[] args) {
        String fName = "Data/blockedDomains.txt";
        ArrayList<String> inLines = getBlockedDomains(fName);
        System.out.printf("\nSize: %s", inLines.size());
        LinkedHashSet<String> bDomains = convertToHash(inLines);
        System.out.printf("\nSize: %s", bDomains.size());
        Boolean keepGoing = true;
        while (keepGoing){
            String uIn = getUserInput();
            if (uIn.equalsIgnoreCase("STOP")){
                keepGoing = false;
                break;
            }
            if (bDomains.contains(uIn)){
                System.out.printf("That no good: %s", uIn);
            }else{
                System.out.printf("That OK: %s", uIn);
            }
        }
        showMeTheList(bDomains);


    }

    private static void showMeTheList(LinkedHashSet<String> bDomains) {
        for(String d : bDomains){
            System.out.printf("\nDomainn: %s", d);
        }
    }

    private static String getUserInput() {
        System.out.printf("\nEnter domain to check (or STOP): ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private static LinkedHashSet<String> convertToHash(ArrayList<String> inLines) {
        LinkedHashSet<String> bDom = new LinkedHashSet<>();
        for (String line : inLines){
            bDom.add(line);
        }
        return bDom;
    }

    private static ArrayList<String> getBlockedDomains(String fName){

        FileIOV2 fio = new FileIOV2(fName);
        try {
            fio.setFileData();
        }catch (Exception e){
            System.out.printf("\nfName: %s problem", fName);
            System.out.printf("\nException: %s", e.getMessage());
            System.exit(1);
        }
        ArrayList<String> blockedDomains = fio.getFileData();
        return blockedDomains;
    }
}
