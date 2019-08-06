public class binTree {
	
	//protected btNode root;
	 
    /* Constructor */
    public binTree()
    {
        Object root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Functions to insert data */
    public void insert(int data)
    {
        root = insert(root, data);
    }
    
    
    /* Function to insert data recursively */
    private btNode insert(btNode node, int data)
    {
        if (node == null)
            node = new btNode(data);
        else
        {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }


  
   
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root); //calls private preorder(btNode r)
    }
    private void preorder(btNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" "); //visits root
            preorder(r.getLeft());             //visit left
            preorder(r.getRight());				//visti right
        }
    }
    
    public void postorder()
    {
        postorder(root); //calls private postorder(btNode)
    }
    public void inorder()
    {
        inorder(root); //calls private inorder(btNode root)
    }
    private void inorder(btNode root)
    {
        //TO DO by students
         if(root != null){
        	 inorder(root.getLeft()); //visit left
        	 System.out.print(root.getData() + ", "); //visit root
        	 inorder(root.getRight()); //visit right 
         }
    }
    
    public int findSmallest()
    {
        return findSmallest(root);
    }
    private int findSmallest(btNode root)
    {
       btNode curr = root;
       
       while(curr.left != null){
    	   curr = curr.left;
       }
       return curr.data;
    }
    
 private void postorder(btNode root)
    {
    	//TO DO by students
	 	if(root != null){
    	  postorder(root.getRight()); //visit right
    	  postorder(root.getLeft());  //visit left
    	  System.out.println(root.getData() + " ");  //visit root
    	}
    }
   

    
   public int findHeight(btNode root) {
     // TO DO by students
      if(root == null){
    	  return 0;
      }
      
      int lh = findHeight(root.getLeft()); //height of left side
      int rh = findHeight(root.getRight()); //height of right side
      
      return Math.max(lh,rh)+1; //height of tree
    }
    
   public boolean remove(int num) {
       if (root == null)
             return false;
       else {
             if (root.getData() == num) {
                   btNode root2 = new btNode();
                   root2.setLeft(root);
                   boolean result = root.remove(num, root2);
                   root = root2.getLeft();
                   return result;
             } else {
                   return root.remove(num, null);
             }
       }
 }
   public void delete(int m){
	root = delete(root, m);
   }
  
   private btNode delete(btNode b, int m){
	   if(b == null){
		   return b;
	   }
	   
	   //if b does not exist in tree
	   if(search(b,m) == null){
		   return null;
	   }
	
	   else{
		 
		   	   //if theres no left child but is a right child, set root = right
			   if(b.getLeft() == null && b.getRight() != null){
				   b = b.getRight();
			   }
			 
			   //if theres no right child but is a left child, set root = left
			   else if(b.getRight() == null && b.getLeft() != null){
				   b = b.getLeft();
			   }
			 
			   //if theres 2 children, b = max of left/right, delete max of left/right
			   else if(b.getLeft() != null && b.getRight() != null){
				  
				   m=Math.max(b.getLeft().getData(), b.getRight().getData());
				   b.setData(m);
				  
				   delete(b, m);
				   
			   }
			   
		   }
	   
	   return null;
   }
   
   
  
   
   public btNode search(int m){
	   return search(root, m);
   }
   private btNode search(btNode r, int m){
	   btNode curr = r;
	   
	   //if found
	   if(curr.getData() == m){
		   return curr;
	   }
	   
	   else if(curr.getData() >= m){
		   return search(curr.getLeft(), m);//left subtree result
	   }
	   else if(curr.getData() <= m){
		   return search(curr.getRight(), m);//right subtree result
	   }
	   return null; //if tree is empty
   }
   
  
    
   public int countNodes(){
	  return countNodes(root);
   }
   
   private int countNodes(btNode r){
	   //if empty
	   if(r == null){
		   return 0;
	   }
	   //else, return recursive count of left and right + 1
	   return 1+countNodes(r.getLeft())+countNodes(r.getRight());
   }
   
   
  
   
	   
   }