package gameshop;


public class BSTNode {
    public ShopItem data;
    public BSTNode left;
    public BSTNode right;
    
    public BSTNode(ShopItem data){
        this.data = data;
        left=right=null;
    }   
    
}
