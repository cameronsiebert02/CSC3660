import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionHWTests {
    @Test
    public void testNormal(){
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList( 5, 10, 15, 20 ));
        int sum = 0;
        int spot = numbs.size();
        assertEquals(50, RecursionHW.getSum( numbs, sum, spot-1 ));
    }
    @Test
    public void testEmpty(){
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList());
        int sum = 0;
        int spot = numbs.size();
        assertEquals(0, RecursionHW.getSum( numbs, sum, spot-1 ));
    }
    @Test
    public void testOne(){
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList(75));
        int sum = 0;
        int spot = numbs.size();
        assertEquals(75, RecursionHW.getSum( numbs, sum, spot-1 ));
    }
    @Test
    public void testNormal2(){
        String inString = "Purple Apples str pretty Pleasing p";
        char tok = 'p';
        int loc = inString.length()-1;
        int sum2 = 0;
        assertEquals(5, RecursionHW.getHowMany(inString, tok, sum2, loc));
    }
    @Test
    public void testEmpty2(){
        String inString = "";
        char tok = 'p';
        int loc = inString.length()-1;
        int sum2 = 0;
        assertEquals(0, RecursionHW.getHowMany(inString, tok, sum2, loc));
    }
    @Test
    public void testAllCaps(){
        String inString = "PURPLE APPLES STR PRETTY PLEASING P";
        char tok = 'p';
        int loc = inString.length()-1;
        int sum2 = 0;
        assertEquals(0, RecursionHW.getHowMany(inString, tok, sum2, loc));
    }
}
