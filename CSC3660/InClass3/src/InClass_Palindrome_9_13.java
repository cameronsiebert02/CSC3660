import java.util.Locale;

public class InClass_Palindrome_9_13 {
    public static void main(String[] args) {
        String str1 = "hannah";
        System.out.printf("\nIs Palindrome: %s", isPalin1(str1));
        System.out.printf("\nIs PalindromeRecurs: %s", isPalinRecur(str1));
    }
    public static Boolean isPalinRecur(String str1) {
        if(str1.length() <= 1){
            return true;
        }else if (str1.charAt(0) != str1.charAt(str1.length()-1)){
            return false;
        }else {
            return isPalinRecur(str1.substring(1, str1.length()-1));
        }
    }

    private static Boolean isPalin1(String str1) {
        int check = str1.length()-1;
        for(int i = 0; i < str1.length()/2; i++){
            if(str1.toLowerCase(Locale.ROOT).charAt(i) != str1.toLowerCase(Locale.ROOT).charAt(check)){
                return false;
            }
            check--;
        }
        return true;
    }
}
