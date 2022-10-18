import java.util.ArrayList;

public class Examples {
    public static void main(String[] args) {
        int[] myNumbs = new int[]{ 1, 2, 3, 4, 5};
        int res = doStuff( myNumbs, myNumbs.length-1 );
        System.out.printf("\n%s", res);
    }
    private static int doStuff(int[] myNumbs, int l ) {
        if ( l < 0 ) return 0;
        if ( myNumbs[l]%2 == 0){
            return myNumbs[l]+doStuff( myNumbs, l-1);
        } else {
            return 0+doStuff( myNumbs, l-1);
        }
    }
}
