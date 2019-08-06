public class BinaryTree2<AnyType>
{
    public BinaryTree2( )
    {
        root = null;
    }

    public BinaryTree2( AnyType rootItem )
    {
        root = new BinaryNode<AnyType>( rootItem, null, null );
    }

    public void printPreOrder( )
    {
        if( root != null )
            root.printPreOrder( );
    }

    public void printInOrder( )
    {
        if( root != null )
           root.printInOrder( );
    }

    public void printPostOrder( )
    {
        if( root != null )
           root.printPostOrder( );
    }

    public void makeEmpty( )
    {
        root = null;
    }

    public boolean isEmpty( )
    {
        return root == null;
    }
    
    /**
     * Merge routine for BinaryTree class.
     * Forms a new tree from rootItem, t1 and t2.
     * Does not allow t1 and t2 to be the same.
     * Correctly handles other aliasing conditions.
     */
    public void merge( AnyType rootItem, BinaryTree2<AnyType> t1, BinaryTree2<AnyType> t2 )
    {
        if( t1.root == t2.root && t1.root != null )
        {
            System.err.println( "leftTree==rightTree; merge aborted" );
            return;
        }

            // Allocate new node
        root = new BinaryNode<AnyType>( rootItem, t1.root, t2.root );

            // Ensure that every node is in one tree
        if( this != t1 )
            t1.root = null;
        if( this != t2 )
            t2.root = null;
    }

    public int size( )
    {
        return BinaryNode.size( root );
    }

    public int height( )
    {
        return BinaryNode.height( root );
    }

    public BinaryNode<AnyType> getRoot( )
    {
        return root;
    }
    
    private BinaryNode<AnyType> root;

    static public void main( String [ ] args )
    {
        BinaryTree2<Integer> t1 = new BinaryTree2<Integer>( 1 );
        BinaryTree2<Integer> t3 = new BinaryTree2<Integer>( 3 );
        BinaryTree2<Integer> t5 = new BinaryTree2<Integer>( 5 );
        BinaryTree2<Integer> t7 = new BinaryTree2<Integer>( 7 );
        BinaryTree2<Integer> t2 = new BinaryTree2<Integer>( );
        BinaryTree2<Integer> t4 = new BinaryTree2<Integer>( );
        BinaryTree2<Integer> t6 = new BinaryTree2<Integer>( );

        t2.merge( 2, t1, t3 );
        t6.merge( 6, t5, t7 );
        t4.merge( 4, t2, t6 );

        System.out.println( "t4 should be perfect 1-7; t2 empty" );
        System.out.println( "----------------" );
        System.out.println( "t4" );
        t4.printInOrder( );
        System.out.println( "----------------" );
        System.out.println( "t2" );
        t2.printInOrder( );
        System.out.println( "----------------" );
        System.out.println( "t4 size: " + t4.size( ) );
        System.out.println( "t4 height: " + t4.height( ) );
    }
}
//BinaryNode class; stores a node in a tree.
//
//CONSTRUCTION: with (a) no parameters, or (b) an Object,
//  or (c) an Object, left child, and right child.
//
//*******************PUBLIC OPERATIONS**********************
//int size( )            --> Return size of subtree at node
//int height( )          --> Return height of subtree at node
//void printPostOrder( ) --> Print a postorder tree traversal
//void printInOrder( )   --> Print an inorder tree traversal
//void printPreOrder( )  --> Print a preorder tree traversal
//BinaryNode duplicate( )--> Return a duplicate tree

/**
* Binary node class with recursive routines to
* compute size and height.
*/
final class BinaryNode<AnyType>
{
 public BinaryNode( )
 {
     this( null, null, null );
 }
 
 public BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
 {
     element = theElement;
     left    = lt;
     right   = rt;
 }

 /**
  * Return the size of the binary tree rooted at t.
  */
 public static <AnyType> int size( BinaryNode<AnyType> t )
 {
     if( t == null )
         return 0;
     else
         return 1 + size( t.left ) + size( t.right );
 }

 /**
  * Return the height of the binary tree rooted at t.
  */
 public static <AnyType> int height( BinaryNode<AnyType> t )
 {
     if( t == null )
         return -1;
     else
         return 1 + Math.max( height( t.left ), height( t.right ) );
 }

 // Print tree rooted at current node using preorder traversal.
 public void printPreOrder( )
 {
     System.out.println( element );       // Node
     if( left != null )
         left.printPreOrder( );           // Left
     if( right != null )
         right.printPreOrder( );          // Right
 }


 // Print tree rooted at current node using postorder traversal.
 public void printPostOrder( )
 {
     if( left != null )
         left.printPostOrder( );          // Left
     if( right != null )
         right.printPostOrder( );         // Right
     System.out.println( element );       // Node
 }

 // Print tree rooted at current node using inorder traversal.
 public void printInOrder( )
 {
     if( left != null )
         left.printInOrder( );            // Left
     System.out.println( element );       // Node
     if( right != null )
         right.printInOrder( );           // Right
 }


 /**
  * Return a reference to a node that is the root of a
  * duplicate of the binary tree rooted at the current node.
  */
 public BinaryNode<AnyType> duplicate( )
 {
     BinaryNode<AnyType> root = new BinaryNode<AnyType>( element, null, null );

     if( left != null )            // If there's a left subtree
         root.left = left.duplicate( );    // Duplicate; attach
     if( right != null )          // If there's a right subtree
         root.right = right.duplicate( );  // Duplicate; attach
     return root;                      // Return resulting tree
 }
 
 public AnyType getElement( )
 {
     return element;
 }
 
 public BinaryNode<AnyType> getLeft( )
 {
     return left;
 }
 
 public BinaryNode<AnyType> getRight( )
 {
     return right;
 }
 
 public void setElement( AnyType x )
 {
     element = x;
 }
 
 public void setLeft( BinaryNode<AnyType> t )
 {
     left = t;
 }
 
 public void setRight( BinaryNode<AnyType> t )
 {
     right = t;
 }

 private AnyType             element;
 private BinaryNode<AnyType> left;
 private BinaryNode<AnyType> right;
}