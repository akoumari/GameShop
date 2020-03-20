package gameshop;


public class BSTree {
    
    private BSTNode root;
    
    public BSTree(){
        root=null;
    }
     
    public boolean search(int key){
        if (root==null){
            return false;
        }
        BSTNode curr=root;
        while (curr!=null && curr.data!=key){
            if (curr.data>key){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
        if (curr==null){
            return false;
        }     
        return true;
    }
    
    public void insert(int key){
        BSTNode newNode = new BSTNode(key);
        if (root == null){
            root=newNode;
            return;
        }
        BSTNode parent,current;
        current=parent=root;
        while (current!=null){
            parent=current;
            if (current.data>key){
                current=current.left;
            }else{
                current=current.right;
            }
        }
        if (parent.data>key){
                parent.left=newNode;
            }else{
                parent.right=newNode;
            }       
    }
    
    public void inOrderTrav(){
        System.out.print("In Order Traversal:");
        recInOrder(root);
        System.out.println("");
    }
    
    public void recInOrder(BSTNode curr){
        if (curr!=null){
            recInOrder(curr.left);
            System.out.print(" "+curr.data);
            recInOrder(curr.right); 
        }
    }
    
     public void postOrderTrav(){
        System.out.print("Post Order Traversal:");
        recPostOrder(root);
        System.out.println("");
    }
    
    public void recPostOrder(BSTNode curr){
        if (curr!=null){
            recPostOrder(curr.left);
            recPostOrder(curr.right); 
            System.out.print(" "+curr.data);
        }
    }
    
     public void preOrderTrav(){
        System.out.print("Pre Order Traversal:");
        recPreOrder(root);
        System.out.println("");
    }
    
    public void recPreOrder(BSTNode curr){
        if (curr!=null){
            System.out.print(" "+curr.data);
            recPreOrder(curr.left);
            recPreOrder(curr.right); 
        }
    }
}
