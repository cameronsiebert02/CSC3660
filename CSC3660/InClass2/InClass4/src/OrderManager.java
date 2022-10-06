import java.util.ArrayList;
import java.util.HashSet;

public class OrderManager {
    private ArrayList<OrderItem> orders = new ArrayList<>();
    HashSet<Integer> byOrderId = new HashSet<>();
    public OrderManager (ArrayList<OrderItem> orders){
        this.orders = orders;
        for (OrderItem o : orders){
            byOrderId.add(o.getOrder_id());
        }
    }
    public ArrayList<OrderItem> findOrder(int inOId){
        ArrayList<OrderItem> retItems = new ArrayList<>();
        for(OrderItem item : orders){
            if(item.getOrder_id() == inOId){
                retItems.add(item);
            }
        }
        return retItems;
    }
    public Boolean gotThisOrder(int inOId){
        for(OrderItem item : orders){
            if(item.getOrder_id() == inOId){
                return true;
            }
        }
        return false;
    }
    public Boolean gotThisOrderhash(int inOId){
        if(byOrderId.contains(inOId)){
            return true;
        }
        return false;
    }
}
