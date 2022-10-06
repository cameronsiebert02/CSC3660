public class InClass_9_8Recur1 {
    public static void main(String[] args) {
        int n = 5;
        int fact1 = getFactorial1(n);
        System.out.printf("\nFactorial of %s is: %s", n, fact1);

        int fact2 = factorialRecur(n);
        System.out.printf("\nFactorialRecur of %s is: %s", n, fact2);
    }

    private static int factorialRecur(int n) {
        if (n <= 1){
            return 1;
        }else {
            return n * factorialRecur(n-1);
        }
    }

    private static int getFactorial1(int n) {
        int fact = 1;
        for(int i = n;i > 0; i--){
            fact *= i;
        }
        return fact;
    }
}
