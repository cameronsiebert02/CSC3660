public class BST {
    public BSTNode root = null;

    public void inOrderTraversal(BSTNode focusNode){
        if(focusNode != null){
            inOrderTraversal(focusNode.leftChild);
            System.out.printf("\nNode: %s Name: %s", focusNode.key, focusNode.name);
            inOrderTraversal(focusNode.rightChild);
        }
    }
    public BSTNode findNode(int key){
        // Return null or the node
        BSTNode focusNode = root;
        while(focusNode.key != key){
            if(key < focusNode.key){
                focusNode = focusNode.leftChild;
            }else{
                focusNode = focusNode.rightChild;
            }
            if(focusNode == null){
                return null;
            }
        }
        return focusNode;
    }
    public void addNode(int key, String name){
        BSTNode newNode = new BSTNode(key, name);
        if(root == null){
            root = newNode;
        }else{
            //already have a root
            BSTNode focusNode = root;
            BSTNode parent = root;
            while(true){
                parent = focusNode;
                if(key < focusNode.key){
                    // Going to put it to the left
                    focusNode = focusNode.leftChild;
                    if (focusNode == null){
                        // leftchild has no children
                        // Set parent to newNode
                        parent.leftChild = newNode;
                        return;
                    }
                }else {
                    // go to right
                    focusNode = focusNode.rightChild;
                    if (focusNode == null){
                        // rightchild has no children
                        // Set parent to newNode
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
}