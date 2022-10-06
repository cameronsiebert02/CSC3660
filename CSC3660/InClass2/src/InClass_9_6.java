public class InClass_9_6 {
    public static void main(String[] args) {
//        String name = "D";                              // Generally used because it's less typing
//        name += "B";
//        StringBuilder nameSB = new StringBuilder("D");  // Not too much longer to execute, almost unnoticeable
//        nameSB.append("B");
//        nameSB.append(99);
//        System.out.printf("\nName: %s nameSB: %s", name, nameSB.toString());
        String name = "D";
        int n = 1000000;
        appendToString(n, name);
        String name2 = "D";
        appendToStringBuilder(n, name2);
    }

    private static void appendToString(int n, String name) {
        long startTime = System.currentTimeMillis();        // Epoch time = January 1st, 1970
        for(int i = 0; i < n; i++){
            name += "A";
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("\nString n: %s Time: %s", n, endTime-startTime);
    }
    private static void appendToStringBuilder(int n, String name) {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(name);
        for(int i = 0; i < n; i++){
            sb.append("A");
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("\nSB n: %s Time: %s", n, endTime-startTime);
    }
}
