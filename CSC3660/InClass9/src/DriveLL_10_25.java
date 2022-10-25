public class DriveLL_10_25 {
    public static void main(String[] args) {
        LinkedListNode1 ll = new LinkedListNode1();
        ll.addNode("Apple");
        ll.addNode("Baker");
        ll.addNode("Charlie");
        ll.addNode("Dog");
        if(ll.isItInThere("Baker")){
            System.out.printf("\nYes to Baker");
        }
        if(ll.isItInThere("Blah")){
            System.out.printf("\nYes to Baker");
        }
        System.out.printf("\nThis size: %s", ll.getSize());
        Node1 n = ll.removeThisItem("Baker");
        System.out.printf("\nNode: %s Size: %s", n.value, ll.getSize());

        Node1 theNode = ll.getLLHead();
        int i = 0;
        while(theNode != null){
            System.out.printf("\ni: %s val: %s", ++i, theNode.value);
            theNode = theNode.next;
        }
    }
}