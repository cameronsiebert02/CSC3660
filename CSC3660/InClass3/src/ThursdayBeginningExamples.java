public class ThursdayBeginningExamples {
    public static void main(String[] args) {
//        String s = "apples";
//        String s2 = s.substring(1, s.length()-1);
//        System.out.printf("\n%s", s2);
        String s = "baseball";
        StringBuilder t = getreverseString(s);
        System.out.printf("\nbaseball backwards is: %s", t.toString());
    }

    private static StringBuilder getreverseString(String s) {
        StringBuilder t = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            t.append(s.substring(i, i+1));
        }
        return t;
    }
}
