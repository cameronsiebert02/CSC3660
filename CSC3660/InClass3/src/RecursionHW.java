import java.util.ArrayList;
import java.util.Arrays;

public class RecursionHW {
    public static void main(String[] args) {
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList( 5, 10, 15, 20 ));
        int sum = 0;
        int spot = numbs.size();
        sum = getSum( numbs, sum, spot-1 );
        System.out.printf("\nsum:%s", sum);

        System.out.printf("\n ---------------");
        String inString = "Purple Apples str pretty Pleasing p";
        char tok = 'p';
        int loc = inString.length()-1;
        int sum2 = 0;
        int ct = getHowMany( inString, tok, sum2, loc);
        System.out.printf("\ngetHowMany ct:%s", ct);

    }

    public static int getHowMany(String inString, char tok, int sum2, int loc) {
        if(loc < 0){
            return sum2;
        }else if(inString.charAt(loc) == tok ){
            sum2++;
            loc--;
            return getHowMany(inString, tok, sum2, loc);
        }else {
            loc--;
            return getHowMany(inString, tok, sum2, loc);
        }
    }

    public static int getSum(ArrayList<Integer> numbs, int sum, int i) {
        if(i < 0){
            return sum;
        }else {
            sum += numbs.get(i);
            i--;
            return getSum(numbs, sum, i);
        }
    }
}
