import java.util.LinkedList;
import java.util.Queue;

public class BSTInClass_11_10 {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.addNode(50, "Apples");
        bst.addNode(25, "Bananas");
        bst.addNode(35, "Carrot");
        bst.addNode(56, "Donut");
        bst.addNode(58, "Eggs");
        bst.inOrderTraversal(bst.root);
        BSTNode found = bst.findNode(58);
        System.out.printf("\nFound Key: %s Name: %s", found.key, found.name);
        System.out.printf("\n------- Pre-Order ---------");
        bst.preOrderTraversal(bst.root);
        System.out.printf("\n------- Post-Order ---------");
        bst.postOrderTraversal(bst.root);
        System.out.printf("\n--------- Smallest number -----------");
        BSTNode small = bst.smallestItem(bst.root);
        System.out.printf("\nSmallest: %s", small.key);
        System.out.printf("\n---------- Sum ----------");
        System.out.printf("\nThe Sum: %s", addBST(bst.root));
        System.out.printf("\nThe Sum w/ No Recursion: %s", addBSTNoRecur(bst.root));

    }
    public static int addBST(BSTNode root){
        if(root == null) return 0;
        return (root.key + addBST(root.leftChild)) + addBST(root.rightChild);
    }
    public static int addBSTNoRecur(BSTNode root){
        // sum all nodes but don't use recursion
        int sum = 0;
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BSTNode current = queue.poll();         // return and remove front of queue
            sum += current.key;
            if(current.leftChild != null){
                queue.add(current.leftChild);
            }
            if(current.rightChild != null){
                queue.add(current.rightChild);
            }
        }
        return sum;
    }
}