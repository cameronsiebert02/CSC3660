import lib.FileIOV2;

import java.util.ArrayList;
import java.util.TreeMap;

public class SurveySummary_9_29 {
    public static void main(String[] args) {
        String fName = "Data/surveyResults.txt";
        FileIOV2 fio = new FileIOV2(fName);
        ArrayList<String> inLines = null;
        try{
            fio.setFileData();
            inLines = fio.getFileData();
        }catch (Exception e){
            System.out.printf("\nCannot open file: %s", fName);
            System.out.printf("\nMsg: %s", e.getMessage());
            System.exit(1);
        }
//        System.out.printf("\n->Size: %s", inLines.size());
        int field = 0;
        TreeMap<String, Integer> theCounts = CountItems(inLines, field);
        showCounts(theCounts);
        System.out.printf("\n-------------------------");
        int field2 = 1;
        TreeMap<String, Integer> theCounts2 = CountItems(inLines, field2);
        showCounts(theCounts2);
    }

    private static void showCounts(TreeMap<String, Integer> theCounts) {
        for(String key : theCounts.keySet()){
            System.out.printf("\nFor K: %s Ct: %s", key, theCounts.get(key));
        }
    }

    private static TreeMap<String, Integer> CountItems(ArrayList<String> inLines, int field) {
        TreeMap<String, Integer> theCounts = new TreeMap<>();
        for(String line : inLines){
            String[] toks = line.split(",");
            if(field > toks.length-1){
                throw new IndexOutOfBoundsException("Wow field too big" + field);
            }
            String item = toks[field];
            if(!theCounts.containsKey(item)){
                theCounts.put(item, 1);
            }else{
                int ct = theCounts.get(item);
                ct += 1;
                theCounts.put(item, ct);
            }
        }
        return theCounts;
    }
}
