public class DoubleLL_10_27 {
    class Node {
        int item;
        Node previous;
        Node next;

        public Node(int item) {
            this.item = item;
            next = null;
            previous = null;
        }
    }

    Node head, tail = null;

    public void addNode(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            //It's the first node
            head = newNode;
            tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void printNodes() {
        Node current = head;
        System.out.printf("\n--- Showing the nodes ---");
        int ct = 0;
        while (current != null) {
            System.out.printf("\nCt: %s Item: %s", ++ct, current.item);
            current = current.next;
        }
    }

    public void printNodesInReverse() {
        Node current = tail;
        System.out.printf("\n--- Showing the nodes ---");
        int ct = 0;
        while (current != null) {
            System.out.printf("\nCt: %s Item: %s", ++ct, current.item);
            current = current.previous;
        }
    }
    public int popTail(){
        // ToDo: Remove the last item
        // Return -99 if not there
        // Else return the value of the last item
        int value = -99;
        if(head == null && tail == null){
            return value;
        }else if(head == tail){
            value = head.item;
            head = null;
            tail = null;
        }else{
            value = tail.item;
            tail = tail.previous;
            tail.next = null;
        }
        return value;
    }
}