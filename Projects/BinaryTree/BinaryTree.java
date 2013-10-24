
public class BinaryTree {
    private BinaryNode root;

    public BinaryTree(){root=null;}

    public BinaryTree(int x){
        root = new BinaryNode(x);
    }

    public boolean isEmpty(){return root == null;}
    public void makeEmpty(){root=null;}
    public int nodeCount(){return BinaryNode.nodeCount(root);}
    public int height(){return BinaryNode.height(root);}

    public int getRootValue()
    {	
        return root.data;
    }

    public void setRootValue(int x)
    {
        root.data = x;
    }

    public BinaryTree getLeft()
    {
        BinaryTree t = new BinaryTree();
        t.root = root.left;
        return t;
    }

    public void setLeft(BinaryTree t)
    {
        root.left = t.root;
    }

    public BinaryTree getRight()
    {
        BinaryTree t = new BinaryTree();
        t.root = root.right;
        return t;
    }

    public void setRight(BinaryTree t)
    {
        root.right = t.root;
    }

    public void addValue(int x){
        BinaryNode newNode = new BinaryNode(x);

        // If there is no root this becomes root

        if (root == null) {

            root = newNode;

        } else {

            // Set root as the Node we will start
            // with as we traverse the tree

            BinaryNode focusNode = root;

            // Future parent for our new Node

            BinaryNode parent;

            while (true) {

                // root is the top parent so we start
                // there

                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node

                if (x < focusNode.data) {

                    // Switch focus to the left node

                    focusNode = focusNode.left;

                    // If the left node has no children

                    if (focusNode == null) {

                        // then place the new node on the left of it

                        parent.left = newNode;
                        return; 

                    }

                } else { // If we get here put the node on the right

                    focusNode = focusNode.right;

                    // If the right node has no children

                    if (focusNode == null) {

                        // then place the new node on the right of it

                        parent.right = newNode;
                        return; 
                    }
                }
            }
        }
    }
}
