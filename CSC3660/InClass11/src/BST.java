public class BST {
    public BSTNode root = null;

    public void inOrderTraversal(BSTNode focusNode){
        if(focusNode != null){
            inOrderTraversal(focusNode.leftChild);
            System.out.printf("\nNode: %s Name: %s", focusNode.key, focusNode.name);
            inOrderTraversal(focusNode.rightChild);
        }
    }
    public void preOrderTraversal(BSTNode focusNode){
        if(focusNode != null){
            // node -> traverse left -> traverse right
            System.out.printf("\nNode: %s Name: %s", focusNode.key, focusNode.name);
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }
    public void postOrderTraversal(BSTNode focusNode){
        if(focusNode != null){
            // traverse left -> traverse right -> root
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.printf("\nNode: %s Name: %s", focusNode.key, focusNode.name);
        }
    }
    public BSTNode smallestItem(BSTNode focusNode){
        BSTNode theNode = focusNode;
        if(focusNode.leftChild != null){
            theNode = focusNode.leftChild;
        }
        return theNode;
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