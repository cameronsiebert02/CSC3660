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
    }
}
