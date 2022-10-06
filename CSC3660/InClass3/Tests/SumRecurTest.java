import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumRecurTest {
    @Test
    public void testNormal(){
        int n = 5;
        int ret = InClass_9_13.getRecurSum(n);
        assertEquals(15, ret);
    }
    @Test
    public void testOne(){
        int n = 1;
        int ret = InClass_9_13.getRecurSum(n);
        assertEquals(1, ret);
    }
    @Test
    public void testTwo(){
        int n = 2;
        int ret = InClass_9_13.getRecurSum(n);
        assertEquals(3, ret);
    }
    @Test
    public void testZero(){
        int n = 0;
        int ret = InClass_9_13.getRecurSum(n);
        assertEquals(0, ret);
    }
}
