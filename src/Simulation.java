import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.*;


public class Simulation {

    public ArrayList loadItems(String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fileName));



        ArrayList<Item> list = new ArrayList<Item>();

        String scan;

        while(s.hasNextLine()) {
            Item newItem = new Item();
            String[] tokens = s.nextLine().split("=");
            newItem.nameItem = tokens[0];
            newItem.weightItem = Integer.parseInt(tokens[tokens.length-1]);

            list.add(newItem);

        }
        return list;
    }

    public ArrayList loadU1 (ArrayList itemlist){
       ArrayList<U1> rockets = new ArrayList<U1>();
       Iterator itr = itemlist.iterator();

       while(itr.hasNext()){
           U1 tempRocket = new U1();
           Item tempItem;

           tempItem = (Item) itr.next();

           while(tempRocket.canCarry(tempItem) && itr.hasNext()){
                tempRocket.carry(tempItem);
                tempItem = (Item) itr.next();
           }
           if(tempRocket.canCarry(tempItem)&& !itr.hasNext()){
               tempRocket.carry(tempItem);
           }
        rockets.add(tempRocket);
       }
        return rockets;
    }

    public ArrayList loadU2 (ArrayList itemlist){
        ArrayList<U2> rockets = new ArrayList<U2>();
        Iterator itr=itemlist.iterator();

        while(itr.hasNext()){
            U2 temp = new U2();
            Item tempItem;

            tempItem = (Item) itr.next();

            while(temp.canCarry(tempItem) && itr.hasNext()){
                temp.carry(tempItem);
                tempItem = (Item) itr.next();
            }
            if(temp.canCarry(tempItem)&& !itr.hasNext()){
                temp.carry(tempItem);
            }
            rockets.add(temp);
        }
        return rockets;
    }

    public int runSimulation(ArrayList rockets){
        Iterator itr = rockets.iterator();
        int budget=0;

        if (itr.next() instanceof U1){
            U1 tempU1 = new U1();

            while(itr.hasNext()){
                tempU1 = (U1) itr.next();

                while(!tempU1.launch() || !tempU1.land()){
                    budget = budget + tempU1.rocketCost;
                }
                budget= budget + tempU1.rocketCost;

            }
            return budget;
        }

        else{
            U2 tempU2 = new U2();

            while(itr.hasNext()){
                tempU2 = (U2) itr.next();

                while(!tempU2.launch() || !tempU2.land()){
                    budget = budget + tempU2.rocketCost;
                }
                budget= budget + tempU2.rocketCost;

            }
            return budget;
        }

    }

}
