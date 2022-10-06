import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {
    @Test
    public void testS2(){
        String s = "apples";
        String s2 = s.substring(1, s.length()-1);
        assertEquals("pple", s2);
    }
}
