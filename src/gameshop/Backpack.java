
package gameshop;
// This class should implement a backpack as a linked list
    // The backpack can hold any number of weapons as long as maxWeight is not crossed.
    // If an attempt to add a weapon to backpack is rejected due to weight
    class Backpack
    {
        double maxWeight;
        double presentWeight;
        private BPNode head;
        
        public Backpack(double maxWeight){
            this.maxWeight = maxWeight;
            presentWeight = 0;
            this.head = null;
        }
        
        public boolean buy(Weapon weapon){
            if(presentWeight + weapon.weight > maxWeight){
                System.out.println("Sorry your not strong enough to carry your bag if you add that item... It will exceed your max weight");
                return false;
            }
            presentWeight += weapon.weight;
            BPNode n = new BPNode(weapon, 1);
            if(head==null){
                head = n;
                return true;
            }
            BPNode curr = head;
            if(curr.data.weaponName.compareToIgnoreCase(weapon.weaponName) == 0){
                    curr.quantity++;
                    return true;
            }
            while(curr.next != null){
                if(curr.data.weaponName.compareToIgnoreCase(weapon.weaponName) == 0){
                    curr.quantity++;
                    return true;
                }
                curr = curr.next;
            }
            curr.next = n;
            return true;
        }
            public void printWeapons(){
                BPNode curr = head;
                while(curr != null){
                    System.out.print(" "+curr.data.weaponName+" Quantity: "+curr.quantity);
                    curr = curr.next;
                }
                System.out.println("");
            }
    }
