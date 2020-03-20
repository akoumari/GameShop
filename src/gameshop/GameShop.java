package gameshop;

import java.util.Scanner;

public class GameShop {

        public static int getInteger(Scanner sc,String message){
            System.out.print(message);
            while (!sc.hasNextInt()) 
            {
                sc.nextLine(); //clear the invalid input ...
                System.out.print(message);
            }
            return sc.nextInt();
        }
        
        public static double getDouble(Scanner sc,String message){
            System.out.print(message);
            while (!sc.hasNextDouble()) 
            {
                sc.nextLine(); //clear the invalid input ...
                System.out.print(message);
            }
            return sc.nextDouble();
        }
        
    
        public static void addWeapons(BSTree stock,Scanner sc)
        {
            System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
            String weaponName; int weaponRange; int weaponDamage; double weaponWeight; double weaponCost;
            int quantity;
            System.out.print("Please enter the NAME of the Weapon ('end' to quit):");
            weaponName=sc.next();
            while (weaponName.compareTo("end") != 0)
            {
                weaponRange= getInteger(sc,"Please enter the Range of the Weapon (0-10):"); 
                weaponDamage=getInteger(sc,"Please enter the Damage of the Weapon:"); 
                weaponWeight= getDouble(sc,"Please enter the Weight of the Weapon (in pounds):");
                weaponCost=getDouble(sc,"Please enter the Cost of the Weapon:");
                Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
                quantity=getInteger(sc,"Please enter the quantity in stock:"); 
                stock.insert(w,quantity);
                System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
                weaponName = sc.next();
            }
        }

        public static void showRoomMenu(BSTree bst,Player p){
            System.out.println("WELCOME TO THE SHOWROOM!!!!");
            bst.inOrderTrav();
            System.out.println("You have "+p.money+" money.");
            System.out.println("Please select a weapon to buy('end' to quit):");
        }
        
        public static void showRoom(BSTree bst, Player p,Scanner sc)
        {
            String choice;
            showRoomMenu(bst,p);
            choice=sc.next();
            while (choice.compareTo("end") != 0)
            {
                BSTNode si = bst.search(choice);
                if (si != null)
                {
                    if (si.data.item.cost > p.money)
                    {
                        System.out.println("Insufficient funds to buy "+si.data.item.weaponName );
                    }
                    else
                    {
                        if(p.buy(si.data.item)){
                        p.withdraw(si.data.item.cost);
                        si.data.numberInStock--;
                        }
                        else{
                            System.out.println("");
                            return;
                        }
                    }
                }
                else
                {
                    System.out.println(" ** "+choice+" not found!! **" );
                }
                showRoomMenu(bst,p);
                choice = sc.next();
            }
            System.out.println("");
        }
        
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            String pname;
            System.out.println("Please enter Player name:");
            pname=sc.next();
            Player pl= new Player(pname,45);
            BSTree bst= new BSTree();
            addWeapons(bst,sc);
            showRoom(bst, pl,sc);
            pl.printCharacter();

        }

}
