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
        public static void delete(BSTree bst,Scanner sc){
            System.out.println("Please enter the NAME of the Weapon to delete ('end' to quit):");
            String weapon = sc.next();
            while (weapon.compareTo("end") != 0)
            {
                bst.delete(weapon); 
                System.out.println("Please enter the NAME of the Weapon to delete ('end' to quit):");
                weapon = sc.next();
            }
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
        public static void menu(Scanner sc, BSTree bst, Player pl){
            int option = 0;
            
            do{
                System.out.println("Greetings traveller! Welcome to the Weapon Shop\n\n" +
                "Please select an option from the list below.\n" +
                "1.Add Weapons to the shop\n" +
                "2.Delete a Weapons from the shop\n" +
                "3.Buy Weapons\n" +
                "4.View Backpack\n" +
                "5.View Charecter\n" +        
                "6.Exit");
                option = sc.nextInt();
                switch(option){
                    case 1: 
                        addWeapons(bst,sc);
                        break;
                    case 2: 
                        delete(bst, sc);
                        break;
                    case 3: 
                        showRoom(bst, pl,sc);
                        break;
                    case 4: 
                        pl.printBackpack();
                        break;
                    case 5: 
                        pl.printCharacter();
                        break;
                    case 6: 
                        System.out.println("\nThank you for being a memeber of the CASUAL WRITERS BOOK CLUB");
                        break;    
                }

            }while(option != 5);
            System.out.println("Well met traveller! Be safe. Endor can be a dangerous place...");


        }
        
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            String pname;
            System.out.println("Please enter Player name:");
            pname=sc.next();
            Player pl= new Player(pname,45);
            BSTree bst= new BSTree();
            menu(sc, bst, pl);
            sc.close();
            
            

        }

}
