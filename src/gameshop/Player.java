package gameshop;

class Player
    {
        public String name;
        public Backpack backpack;
        public int numItems;
        public double money;

        public Player(String n, double m)
        {
            name = n;
            money = m;
            numItems = 0;
            backpack = new Backpack(200);
        }

        public boolean buy(Weapon w)
        {
            System.out.println(w.weaponName+" bought...");
            return backpack.buy(w);
        }
        public void withdraw(double amt)
        {
            money = money - amt;
        }

        public void printCharacter()
        {
            System.out.println(" Name:"+name+"\n Money:"+money);
            printBackpack();
        }

        public void printBackpack()
        {
            System.out.println(" "+name+", your backpack weighs "+backpack.presentWeight+" pounds\n your max capacity is: "+backpack.maxWeight);
            System.out.print(" Backpack Weight: ");
            for(int i =0; i < backpack.maxWeight/10; i++){
                if(i <= backpack.presentWeight/10){
                    System.out.print("#");
                }
                else{
                    System.out.print("=");
                }
            }
            System.out.println("");
            backpack.printWeapons();
            System.out.println();
        }
    }
