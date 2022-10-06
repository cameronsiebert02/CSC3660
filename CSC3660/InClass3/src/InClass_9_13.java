public class InClass_9_13 {
    public static void main(String[] args) {
        int n = 5;
        System.out.printf("\nSum1: %s", getSum(n));
        System.out.printf("\nRecurSum: %s", getRecurSum(n));
    }

    private static int getSum(int n) {
        int ret = 0;
        for(int i = n; i > 0; i--){
            ret += i;
        }
        return ret;
    }
    public static int getRecurSum(int n){
        if (n < 1){
            return n;
        }
        if (n == 1){
            return 1;
        }else{
            return n+getRecurSum(n-1);
        }
    }
}
