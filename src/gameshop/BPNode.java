package gameshop;


public class BPNode {
    public Weapon data;
    public int quantity;
    public BPNode next;
    public BPNode(Weapon data, int quanttity){
        this.quantity = quanttity;
        this.data = data;
        this.next = null;
    }
}
