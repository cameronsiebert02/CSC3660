import lib.FileIOV2;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class InClass_OrderProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        String fName = "Data/order_status.csv";
        FileIOV2 fio = new FileIOV2(fName);
        fio.setFileData();
        ArrayList<String> inLines = fio.getFileData();
        System.out.printf("\nLen: %s", inLines.size());

        ArrayList<OrderItem> items = createOrderItems(inLines);
        System.out.printf("\nGot: %s structured items", items.size());
        OrderManager om = new OrderManager(items);
        ArrayList<OrderItem> retItems = om.findOrder(1234);
        System.out.printf("\nGot items for 1234 size: %s", retItems.size());
        ArrayList<OrderItem> retItems2 = om.findOrder(12345);
        System.out.printf("\nGot items for 1234 size: %s", retItems2.size());
        if(om.gotThisOrder(1234)){
            System.out.printf("Got Order 1234");
        }else {
            System.out.printf("Didn't get order 1234");
        }

//        inLines.add("It's a nice day!");
//        String fName2 = "Data/myNewFile.txt";
        FileIOV2 fio2 = new FileIOV2(fName);
        fio2.writeFileData(inLines);
    }

    private static ArrayList<OrderItem> createOrderItems(ArrayList<String> inLines) {
        ArrayList<OrderItem> items = new ArrayList<>();
//        order_id;line_id;partNum;quantity;shipping_status;value
        boolean firstLine = true;
        for(String line : inLines){
            if (firstLine){
                firstLine = false;
                continue;
            }
            String[] toks = line.split(";");
            try {
                int oId = Integer.parseInt(toks[0]);
                int lId = Integer.parseInt(toks[1]);
                int partNum = Integer.parseInt(toks[2]);
                int quant = Integer.parseInt(toks[3]);
                String status = toks[4];
                double value = Double.parseDouble(toks[5]);
                items.add(new OrderItem(oId, lId, partNum, quant, status, value));
            }catch (Exception e){
                System.out.printf("\n OPE");
                System.exit(1);
            }
        }
        return items;
    }
}
