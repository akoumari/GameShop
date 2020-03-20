package gameshop;


public class BSTree {
    
    private BSTNode root;
    
    public BSTree(){
        root=null;
    }
     
    public BSTNode search(String key){
        if (root==null){
            return null;
        }
        BSTNode curr=root;
        while (curr!=null && curr.data.item.weaponName.compareToIgnoreCase(key) != 0){
            if (curr.data.item.weaponName.compareToIgnoreCase(key) > 0){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
        if (curr==null){
            return null;
        }     
        return curr;
    }
    
    public void insert(Weapon w, int quantity ){
        ShopItem key = new ShopItem(w,quantity);
        BSTNode newNode = new BSTNode(key);
        if (root == null){
            root=newNode;
            return;
        }
        BSTNode parent,current;
        current=parent=root;
        while (current!=null){
            parent=current;
            if (current.data.item.weaponName.compareToIgnoreCase(key.item.weaponName) > 0){
                current=current.left;
            }else if(current.data.item.weaponName.compareToIgnoreCase(key.item.weaponName) == 0){
                System.out.println("Weapon name already exists brother please consider naming it something else!");
                return;
            }
            else{
                current=current.right;
            }
        }
        if (parent.data.item.weaponName.compareToIgnoreCase(key.item.weaponName) > 0){
                parent.left=newNode;
            }else{
                parent.right=newNode;
            }       
    }
    
    public void inOrderTrav(){
        recInOrder(root);
        System.out.println("");
    }
    
    public void recInOrder(BSTNode curr){
        if (curr!=null){
            recInOrder(curr.left);
            if(curr.data.numberInStock > 0){
                System.out.println("Name: " +curr.data.item.weaponName+"   Damage:"+curr.data.item.damage+"    Cost:"+curr.data.item.cost+"     Quantity in stock:"+curr.data.numberInStock);
            }
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
