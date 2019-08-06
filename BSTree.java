import java.util.Scanner;
import java.util.NoSuchElementException;
/* Class Node */
class RedBlackNode
{   
     RedBlackNode left, right;
     int element;
     int color;
     /* Constructor */
     public RedBlackNode(int theElement)
     {
         this( theElement, null, null );
     }
     /* Constructor */
     public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
     {
         left = lt;
         right = rt;
         element = theElement;
         color = 1;
     }   
}
/* Class RBTree */
class RBTree
{
     private RedBlackNode current;
     private RedBlackNode parent;
     private RedBlackNode grand;
     private RedBlackNode great;
     private RedBlackNode header;   
     private static RedBlackNode nullNode;
     /* static initializer for nullNode */
     static
     {
         nullNode = new RedBlackNode(0);
         nullNode.left = nullNode;
         nullNode.right = nullNode;
     }
     /* Black - 1 RED - 0 */
     static final int BLACK = 1;   
     static final int RED   = 0;
     /* Constructor */
     public RBTree(int negInf)
     {
         header = new RedBlackNode(negInf);
         header.left = nullNode;
         header.right = nullNode;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return header.right == nullNode;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         header.right = nullNode;
     }
     /* Function to insert item */
     public void insert(int item )
     {
         current = parent = grand = header;
         nullNode.element = item;
         while (current.element != item)
         {           
             great = grand;
             grand = parent;
             parent = current;
             current = item < current.element ? current.left : current.right;
             // Check if two red children and fix if so           
             if (current.left.color == RED && current.right.color == RED)
                 handleReorient( item );
         }
         // Insertion fails if already present
         if (current != nullNode)
             return;
         current = new RedBlackNode(item, nullNode, nullNode);
         // Attach to parent
         if (item < parent.element)
             parent.left = current;
         else
             parent.right = current;       
         handleReorient( item );
     }
     private void handleReorient(int item)
     {
         // Do the color flip
         current.color = RED;
         current.left.color = BLACK;
         current.right.color = BLACK;
         if (parent.color == RED)  
         {
             // Have to rotate
             grand.color = RED;
             if (item < grand.element != item < parent.element)
                 parent = rotate( item, grand ); // Start dbl rotate
             current = rotate(item, great );
             current.color = BLACK;
         }
         // Make root black
         header.right.color = BLACK;
     }     
     private RedBlackNode rotate(int item, RedBlackNode parent)
     {
         if(item < parent.element)
             return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;
         else
             return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
     }
     /* Rotate binary tree node with left child */
     private RedBlackNode rotateWithLeftChild(RedBlackNode k2)
     {
         RedBlackNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         return k1;
     }
     /* Rotate binary tree node with right child */
     private RedBlackNode rotateWithRightChild(RedBlackNode k1)
     {
         RedBlackNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         return k2;
     }
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(header.right);
     }
     private int countNodes(RedBlackNode r)
     {
         if (r == nullNode)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Functions to search for an element */
     public boolean search(int val)
     {
         return search(header.right, val);
     }
     private boolean search(RedBlackNode r, int val)
     {
         boolean found = false;
         while ((r != nullNode) && !found)
         {
             int rval = r.element;
             if (val < rval)
                 r = r.left;
             else if (val > rval)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(header.right);
     }
     private void inorder(RedBlackNode r)
     {
         if (r != nullNode)
         {
             inorder(r.left);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             inorder(r.right);
         }
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(header.right);
     }
     private void preorder(RedBlackNode r)
     {
         if (r != nullNode)
         {
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             preorder(r.left);            
             preorder(r.right);
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(header.right);
     }
     private void postorder(RedBlackNode r)
     {
         if (r != nullNode)
         {
             postorder(r.left);            
             postorder(r.right);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
         }
     }    
}
/* Class RedBlackTreeTest */
 class RedBlackTreeTest
{
     public static void main(String[] args)
     {           
        Scanner scan = new Scanner(System.in);
        /* Creating object of RedBlack Tree */
        RBTree rbt = new RBTree(Integer.MIN_VALUE);
        System.out.println("Red Black Tree Test\n");         
        char ch;
        /* Perform tree operations */
        do   
        {
            System.out.println("\nRed Black Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. clear tree");
            int choice = scan.nextInt();           
            switch (choice)
            {
            case 1 :
                System.out.println("Enter integer element to insert");
                rbt.insert( scan.nextInt() );                    
                break;                         
            case 2 :
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ rbt.search( scan.nextInt() ));
                break;                                         
            case 3 :
                System.out.println("Nodes = "+ rbt.countNodes());
                break;    
            case 4 :
                System.out.println("Empty status = "+ rbt.isEmpty());
                break;    
            case 5 :
                System.out.println("\nTree Cleared");
                rbt.makeEmpty();
                break;        
            default :
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /* Display tree */
            System.out.print("\nPost order : ");
            rbt.postorder();
            System.out.print("\nPre order : ");
            rbt.preorder();
            System.out.print("\nIn order : ");
            rbt.inorder();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                       
        } while (ch == 'Y'|| ch == 'y');              
     }
}
 import java.util.NoSuchElementException;

 import RedBlackBST.Node;

 public class RedBlackBST<Key extends Comparable<Key>, Value> {

  
     private static final boolean RED   = true;
     private static final boolean BLACK = false;

  
     private Node root;     // root of the BST

  
     // BST helper node data type
     private class Node {
         private Key key;           // key
         private Value val;         // associated data
         private Node left, right;  // links to left and right subtrees
         private boolean color;     // color of parent link
         private int size;          // subtree count

  
         public Node(Key key, Value val, boolean color, int size) {
             this.key = key;
             this.val = val;
             this.color = color;
             this.size = size;
         }
     }
 public RedBlackBST() {
     }
 // is node x red; false if x is null ?
     private boolean isRed(Node x) {
         if (x == null) return false;
         return x.color == RED;
     }
 // number of node in subtree rooted at x; 0 if x is null
     private int size(Node x) {
         if (x == null) return 0;
         return x.size;
     } 

  
 /**
      * Returns the number of key-value pairs in this symbol table.
      * @return the number of key-value pairs in this symbol table
      */
     public int size() {
         return size(root);
     }

  
    /**
      * Is this symbol table empty?
      * @return {@code true} if this symbol table is empty and {@code false} otherwise
      */
     public boolean isEmpty() {
         return root == null;
     }

 /**
      * Returns the value associated with the given key.
      * @param key the key
      * @return the value associated with the given key if the key is in the symbol table
      *     and {@code null} if the key is not in the symbol table
      * @throws NullPointerException if {@code key} is {@code null}
      */
     public Value get(Key key) {
         if (key == null) throw new NullPointerException("argument to get() is null");
         return get(root, key);
     }

  
     // value associated with the given key in subtree rooted at x; null if no such key
     private Value get(Node x, Key key) {
         while (x != null) {
             int cmp = key.compareTo(x.key);
             if      (cmp < 0) x = x.left;
             else if (cmp > 0) x = x.right;
             else              return x.val;
         }
         return null;
     }
 public boolean contains(Key key) {
         return get(key) != null;
     }
 /***************************************************************************
     *  Red-black tree insertion.
     ***************************************************************************/
     /
 public void put(Key key, Value val) {
         if (key == null) throw new NullPointerException("first argument to put() is null");
         if (val == null) {
             delete(key);
             return;
         }

  
         root = put(root, key, val);
         root.color = BLACK;
         // assert check();
     }
 // insert the key-value pair in the subtree rooted at h
     private Node put(Node h, Key key, Value val) { 
         if (h == null) return new Node(key, val, RED, 1);

  
         int cmp = key.compareTo(h.key);
         if      (cmp < 0) h.left  = put(h.left,  key, val); 
         else if (cmp > 0) h.right = put(h.right, key, val); 
         else              h.val   = val;

  
         // fix-up any right-leaning links
         if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
         if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
         if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);
         h.size = size(h.left) + size(h.right) + 1;

  
         return h;
     }

    /***************************************************************************
     *  Red-black tree deletion.
     ***************************************************************************/

  
     /**
      * Removes the smallest key and associated value from the symbol table.
      * @throws NoSuchElementException if the symbol table is empty
      */
     public void deleteMin() {
         if (isEmpty()) throw new NoSuchElementException("BST underflow");

  
         // if both children of root are black, set root to red
         if (!isRed(root.left) && !isRed(root.right))
             root.color = RED;

  
         root = deleteMin(root);
         if (!isEmpty()) root.color = BLACK;
         // assert check();
     }
 // delete the key-value pair with the minimum key rooted at h
     private Node deleteMin(Node h) { 
         if (h.left == null)
             return null;

  
         if (!isRed(h.left) && !isRed(h.left.left))
             h = moveRedLeft(h);

  
         h.left = deleteMin(h.left);
         return balance(h);
     }

  
 public void deleteMax() {
         if (isEmpty()) throw new NoSuchElementException("BST underflow");

  
         // if both children of root are black, set root to red
         if (!isRed(root.left) && !isRed(root.right))
             root.color = RED;

  
         root = deleteMax(root);
         if (!isEmpty()) root.color = BLACK;
         // assert check();
     }
 private Node deleteMax(Node h) { 
         if (isRed(h.left))
             h = rotateRight(h);

  
         if (h.right == null)
             return null;

  
         if (!isRed(h.right) && !isRed(h.right.left))
             h = moveRedRight(h);

  
         h.right = deleteMax(h.right);

  
         return balance(h);
     }
 public void delete(Key key) { 
         if (key == null) throw new NullPointerException("argument to delete() is null");
         if (!contains(key)) return;

  
         // if both children of root are black, set root to red
         if (!isRed(root.left) && !isRed(root.right))
             root.color = RED;

  
         root = delete(root, key);
         if (!isEmpty()) root.color = BLACK;
         // assert check();
     }
 // delete the key-value pair with the given key rooted at h
     private Node delete(Node h, Key key) { 
         // assert get(h, key) != null;

  
         if (key.compareTo(h.key) < 0)  {
             if (!isRed(h.left) && !isRed(h.left.left))
                 h = moveRedLeft(h);
             h.left = delete(h.left, key);
         }
         else {
             if (isRed(h.left))
                 h = rotateRight(h);
             if (key.compareTo(h.key) == 0 && (h.right == null))
                 return null;
             if (!isRed(h.right) && !isRed(h.right.left))
                 h = moveRedRight(h);
             if (key.compareTo(h.key) == 0) {
                 Node x = min(h.right);
                 h.key = x.key;
                 h.val = x.val;
                 // h.val = get(h.right, min(h.right).key);
                 // h.key = min(h.right).key;
                 h.right = deleteMin(h.right);
             }
             else h.right = delete(h.right, key);
         }
         return balance(h);
     }
 /***************************************************************************
     *  Range count and range search.
     ***************************************************************************/

  
     
 public Iterable<Key> keys() {
         if (isEmpty()) return new Queue<Key>();
         return keys(min(), max());
     }
 public Iterable<Key> keys(Key lo, Key hi) {
         if (lo == null) throw new NullPointerException("first argument to keys() is null");
         if (hi == null) throw new NullPointerException("second argument to keys() is null");

  
         Queue<Key> queue = new Queue<Key>();
         // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
         keys(root, queue, lo, hi);
         return queue;
     } 
 public static void main(String[] args) { 
         RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
         for (int i = 0; !StdIn.isEmpty(); i++) {
             String key = StdIn.readString();
             st.put(key, i);
         }
         for (String s : st.keys())
             StdOut.println(s + " " + st.get(s));
         StdOut.println();
     }
 }


