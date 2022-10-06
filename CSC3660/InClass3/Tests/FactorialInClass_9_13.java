import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialInClass_9_13 {
    @Test
    public void recursionSunnyDay(){
        int n = 5;
        int fact = InClass_9_8Recur1.factorialRecur(n);
        assertEquals(120, fact);
    }
    @Test
    public void testZero(){
        int n = 0;
        int fact = InClass_9_8Recur1.factorialRecur(n);
        assertEquals(1, fact);
    }
    @Test
    public void testOne(){
        int n = 1;
        int fact = InClass_9_8Recur1.factorialRecur(n);
        assertEquals(1, fact);
    }
    @Test
    public void testTwo(){
        int n = 2;
        int fact = InClass_9_8Recur1.factorialRecur(n);
        assertEquals(2, fact);
    }
    @Test
    public void testNegative(){
        int n = -1;
        int fact = InClass_9_8Recur1.factorialRecur(n);
        assertEquals(1, fact);
    }
    @Test
    public void testNegative2(){
        int n = -2;
        int fact = InClass_9_8Recur1.factorialRecur(n);
        assertEquals(1, fact);
    }
//    @Test
//    public void testTooBig(){
//        int n = 32;
//        int fact = InClass_9_8Recur1.factorialRecur(n);
//        assertEquals(1, fact);
//    }
}
