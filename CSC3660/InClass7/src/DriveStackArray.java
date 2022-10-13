public class DriveStackArray {
    public static void main(String[] args) throws IllegalAccessException {
        StackArray sa = new StackArray();
        sa.push(12);
        sa.push(22);
        sa.push(32);
        sa.push(42);
        System.out.printf("\nSize: %s", sa.getSize());
        System.out.printf("\nTop: %s", sa.peek());
        System.out.printf("\nPop: %s", sa.pop());
    }
}