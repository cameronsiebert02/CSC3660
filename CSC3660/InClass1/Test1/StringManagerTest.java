import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class StringManagerTest {
    @Test
    public void testApple(){
        String[] inString = {"Apples"};
        StringManager sm = new StringManager(inString);
        assertEquals(2, sm.howManyOfThis('p'));
    }
    @Test
    public void testMultiple(){
        String[] inString = {"Apples", "pinaclep", "PeanutButter"};
        StringManager sm = new StringManager(inString);
        assertEquals(4, sm.howManyOfThis('p'));
    }
    @Test
    public void testEmpty(){
        String[] inString = {};
        StringManager sm = new StringManager(inString);
        assertEquals(0, sm.howManyOfThis('p'));
    }
    @Test
    public void testNone(){
        String[] inString = {"XXXX", "Pickles", "Banana"};
        StringManager sm = new StringManager(inString);
        assertEquals(0, sm.howManyOfThis('p'));
    }
}
