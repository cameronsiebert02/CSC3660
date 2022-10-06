import lib.FileIOV2;

import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.HashSet;

public class OrderManager {
    static ArrayList<OrderItem> orders = new ArrayList<>();

    public static void main(String[] args) {
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = addData(fName);
        orders = addFileData(inLines);
        OrderManager om = new OrderManager();
        om.addOrder(new OrderItem(9999, 1, 444, 12, "shipped", 200));
        om.AddItemToOrder(1235, 1, 10);
        for(OrderItem item : orders){
            if (item.getOrder_id() == 1235){
                System.out.printf("\n%s", item);
            }
        }
        om.updateThisOrderLineId(999, 1, "shipped");
        HashSet<OrderItem> shippedItems = om.getOrdersByState("shipped");
        HashSet<OrderItem> newItems = om.getOrdersByState("new");
        HashSet<OrderItem> pizzaHutItems = om.getOrdersByState("pizzaHut");
        System.out.printf("\nOrder ids: %s", om.getAllOrderId());
        System.out.printf("\nOrder 9999: %s", om.findOrders(9999).size());
        System.out.printf("\nOrder 112358: %s", om.findOrders(112358).size());
    }

    static ArrayList<String> addData(String fName) {
        ArrayList<String> inLines = new ArrayList<>();
        FileIOV2 fio = new FileIOV2(fName);
        try{
            fio.setFileData();
            inLines = fio.getFileData();
        }catch (Exception e){
            System.out.printf("\nCannot open file: %s", fName);
            System.out.printf("\nMsg: %s", e.getMessage());
            System.exit(1);
        }
        return inLines;
    }

    static ArrayList<OrderItem> addFileData(ArrayList<String> inLines) {
        ArrayList<OrderItem> fileData =new ArrayList<>();
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
                fileData.add(new OrderItem(oId, lId, partNum, quant, status, value));
            }catch (Exception e){
                System.out.printf("\n NOPE!");
                System.exit(1);
            }
        }
        return fileData;
    }

    public OrderManager() {
        }
        public void addOrder( OrderItem o){
            orders.add( o );
        }
        public boolean gotThisOrder( int id ){
            // ToDo: Write this method to return O(1) if the id is in the order set
            for(OrderItem item : orders){
                if (item.getOrder_id() == id){
                    return false;
                }
            }
            return false;
        }
        public ArrayList<OrderItem> findOrders(int oId){
            // ToDo: Rewrite this method to operation O(1) instead of O(n)
            ArrayList<OrderItem> retOrder = new ArrayList<>();
            HashSet<OrderItem> ordersHash = new HashSet<>();
            for (OrderItem o : orders){
                ordersHash.add(o);
            }
            //boolean firstLine = true;
            for( OrderItem o : ordersHash ){
                if ( o.getOrder_id() == oId ){
                    retOrder.add(o);
                }

            }
            return retOrder;
        }
    public HashSet<OrderItem> getOrdersByState(String inState ){
            //ToDo: Rewrite this method to be more efficent and use a hash
        HashSet<OrderItem> retOrder = new HashSet<>();
        //boolean firstLine = true;
        for( OrderItem o : orders ){
            if ( o.getStatus().equals(inState) ){
                retOrder.add(o);
            }
        }
        return retOrder;
    }
    // ToDo: Write a method
    public boolean updateThisOrderLineId( int orderId, int lineId, String newStatus ){
            //ToDo: find the orderId and lineId that matches the input and
            //      set status to newStatus.
            // For example:
            //     updateThisOrderLineId( 1233, 1, "staged" )
            // Whould update this this item:
            // From:
            //       1233;1;4;2;shipped;500
            // TO:
            //       1233;1;4;2;staged;500
            // Returns: True -> If the proper item  is found and updated
            //          False -> if cannot find the item OR newStatus is NOT
            //                    new, staged, shipped, picked or delivered.
        for(OrderItem item : orders){
            if(item.getOrder_id() == orderId){
                if (item.getLine_id() == lineId){
                    item.setStatus(newStatus);
                    return true;
                }
            }
        }
        return false;
    }
    public ArrayList<Integer> getAllOrderId(){
        ArrayList<Integer> orders = new ArrayList<>();
            // ToDo: Return arrayList of all the unique orderIds
        HashSet<Integer> uIds = new HashSet<>();
        for(OrderItem item : OrderManager.orders){
            uIds.add(item.getOrder_id());
        }
        for(Integer id : uIds){
            orders.add(id);
        }
        return orders;

    }
    //
    public boolean AddItemToOrder( int OrderId, int partNum,  int quantity ){
            //ToDo:  Search through the orders for OrderNumber and partNum. If it exists
            //       add the quantity to the exsiting order. However if its status is shipped do not
            //       add it and return false.
            // If the orderNumer and partNum is not found then add the order and set lineNumb to 1, and
            //         status to "new"
        for(OrderItem item : orders){
            if (item.getOrder_id() == OrderId){
                if (item.getPartNum() == partNum){
                    if(item.getStatus().equalsIgnoreCase("shipped")){
                        return false;
                    }else{
                        item.setQuantity(quantity);
                        return true;
                    }
                }
            }
        }
        orders.add(new OrderItem(OrderId, 1, partNum, quantity, "new", 20));
        return true;
    }
}