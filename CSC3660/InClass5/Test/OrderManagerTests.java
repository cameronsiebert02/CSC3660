import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;


public class OrderManagerTests {
    @Test
    public void testCaseA(){
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = OrderManager.addData(fName);
        assertEquals(17, inLines.size());
    }
    @Test
    public void testCaseB(){
        ArrayList<OrderItem> orders = new ArrayList<>();
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = OrderManager.addData(fName);
        orders = OrderManager.addFileData(inLines);
        OrderManager om = new OrderManager();
        om.addOrder(new OrderItem(9999, 1, 444, 12, "shipped", 200));
        assertEquals(1, om.getAllOrderId().size());
    }
    @Test
    public void testCaseC(){
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = OrderManager.addData(fName);
        OrderManager om = new OrderManager();
        assertTrue(om.AddItemToOrder(1235, 1, 10));
    }
    @Test
    public void testCaseD(){
        ArrayList<OrderItem> orders = new ArrayList<>();
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = OrderManager.addData(fName);
        orders = OrderManager.addFileData(inLines);
        assertEquals(16, orders.size());
    }
    @Test
    public void testCaseE(){
        // There is no order with orderId = 999 so i created one to make sure it works
        OrderManager.orders.add(new OrderItem(999, 1, 1, 1, "staged", 9.99));
        OrderManager om = new OrderManager();
        assertTrue(om.updateThisOrderLineId(999, 1, "shipped"));
    }
    @Test
    public void testCaseF(){
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = OrderManager.addData(fName);
        OrderManager.orders = OrderManager.addFileData(inLines);
        OrderManager om = new OrderManager();
        HashSet<OrderItem> shippedItems = om.getOrdersByState("shipped");
        assertEquals(9, shippedItems.size());
    }
    @Test
    public void testCaseG(){
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = OrderManager.addData(fName);
        OrderManager.orders = OrderManager.addFileData(inLines);
        OrderManager om = new OrderManager();
        HashSet<OrderItem> newItems = om.getOrdersByState("new");
        assertEquals(0, newItems.size());
    }
    @Test
    public void testCaseH(){
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = OrderManager.addData(fName);
        OrderManager.orders = OrderManager.addFileData(inLines);
        OrderManager om = new OrderManager();
        HashSet<OrderItem> pizzaHutItems = om.getOrdersByState("pizzaHut");
        assertEquals(0, pizzaHutItems.size());
    }
    @Test
    public void testCaseI(){
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = OrderManager.addData(fName);
        OrderManager.orders = OrderManager.addFileData(inLines);
        OrderManager om = new OrderManager();
        om.addOrder(new OrderItem(9999, 1, 444, 12, "shipped", 200));
        assertEquals(1, om.findOrders(9999).size());
    }
    @Test
    public void testCaseJ(){
        String fName = "Data/order_status.csv";
        ArrayList<String> inLines = OrderManager.addData(fName);
        OrderManager.orders = OrderManager.addFileData(inLines);
        OrderManager om = new OrderManager();
        assertEquals(0, om.findOrders(112358).size());
    }
}
