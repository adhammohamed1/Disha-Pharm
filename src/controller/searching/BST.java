package controller.searching;

/**
 * <p>
 * Binary Search Tree</p>
 * ----------------------
 * <p>
 * This data structure is mainly used in searching for objects using specific
 * keys.
 *
 * </p>
 *
 * @param <T> type of keys the tree holds
 * @author Adham Mohamed Aly
 */
public class BST<T> {

    class Node {

        T key;
        Node left, right;

        public Node(T data) {
            key = data;
            left = right = null;
        }

    }

    protected Node root;
    protected Comparer<T> comparer;

    public BST() {
        root = null;
        comparer = new Comparer<>();
    }

    public boolean search(T key) {
        return searchInTree(root, key) != null;
    }

    public void insert(T key) {
        root = insertInTree(root, key);
    }

    public void deleteKey(T key) {
        root = deleteNode(root, key);
    }

    public void printInOrder() {
        inOrder(root);
    }

    public void printPreOrder() {
        preOrder(root);
    }

    public void printPostOrder() {
        postOrder(root);
    }

    public T getInOrderSuccessor(T rootKey) {
        Node node;
        if ((node = searchInTree(root, rootKey)) == null) {
            return null;
        } else if (node.right != null) {
            return minValue(node.right);
        }
        return node.key;
    }

    public T getInOrderPredecessor(T rootKey) {
        Node node;
        if ((node = searchInTree(root, rootKey)) == null) {
            return null;
        } else if (node.left != null) {
            return maxValue(node.left);
        }
        return node.key;
    }

    protected Node deleteNode(Node root, T key) {
        if (root == null) {
            return null;
        }
        if (comparer.compare(root.key, key) > 0) {
            root.left = deleteNode(root.left, key);
        } else if (comparer.compare(root.key, key) < 0) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right); //Get InOrder successor
            root.right = deleteNode(root.right, root.key); // Delete InOrder successor
        }
        return root;
    }

    public T getMinValue(T rootKey) {
        Node node;
        if ((node = searchInTree(root, rootKey)) == null) {
            return null;
        }
        return minValue(node);
    }

    public T getMinValue() {
        if (root == null) {
            return null;
        }
        return minValue(root);
    }

    protected T minValue(Node root) {
        T minval = root.key;
        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    public T getMaxValue(T rootKey) {
        Node node;
        if ((node = searchInTree(root, rootKey)) == null) {
            return null;
        }
        return maxValue(node);
    }

    public T getMaxValue() {
        if (root == null) {
            return null;
        }
        return minValue(root);
    }

    protected T maxValue(Node root) {
        T maxVal = root.key;
        while (root.right != null) {
            maxVal = root.right.key;
            root = root.right;
        }
        return maxVal;
    }

    protected Node insertInTree(Node root, T key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (comparer.compare(root.key, key) > 0) {
            root.left = insertInTree(root.left, key);
        } else if (comparer.compare(root.key, key) < 0) {
            root.right = insertInTree(root.right, key);
        }
        return root;
    }

    protected Node searchInTree(Node root, T key) {
        if (root == null || comparer.compare(root.key, key) == 0) {
            return root;
        }
        if (comparer.compare(root.key, key) > 0) {
            return searchInTree(root.left, key);
        }
        return searchInTree(root.right, key);
    }

    protected void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    protected void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    protected void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }
}

