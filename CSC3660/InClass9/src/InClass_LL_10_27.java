public class InClass_LL_10_27 {
    public static void main(String[] args) {
        System.out.printf("\nStarting...");
        DoubleLL_10_27 dll = new DoubleLL_10_27();
        dll.addNode(12);
        dll.addNode(15);
        dll.addNode(25);
        dll.printNodes();
        dll.printNodesInReverse();
        int popVal = dll.popTail();
        System.out.printf("\nRemoved: %s", popVal);
        dll.printNodes();

        DoubleLL_10_27 dll2 = new DoubleLL_10_27();
        dll2.addNode(12);
        int popVal2 = dll2.popTail();
        System.out.printf("\nRemoved: %s", popVal2);
    }
}