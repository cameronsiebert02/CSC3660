import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeRecurTest {
    @Test
    public void testSimple(){
        String s = "racecar";
        assertTrue(InClass_Palindrome_9_13.isPalinRecur(s));
    }
    @Test
    public void testEvenChar(){
        String s = "abba";
        assertTrue(InClass_Palindrome_9_13.isPalinRecur(s));
    }
    @Test
    public void testFalse(){
        String s = "char";
        assertFalse(InClass_Palindrome_9_13.isPalinRecur(s));
    }
    @Test
    public void testEmpty(){
        String s = "";
        assertTrue(InClass_Palindrome_9_13.isPalinRecur(s));
    }
    @Test
    public void testOne(){
        String s = "s";
        assertTrue(InClass_Palindrome_9_13.isPalinRecur(s));
    }
}
