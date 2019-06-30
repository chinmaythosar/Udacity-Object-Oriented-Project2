public class Rocket implements Main.Spaceship {
    public static double totalWeight;
    public static double weightLimit;


    public boolean launch(){
        return true;
    }
    public boolean land(){
        return true;
    }

    public boolean canCarry(Item item){
        if((item.weightItem + totalWeight) <= weightLimit){
            return true;
        }
        else{
            return false;
        }
    }
    public void carry(Item item){
        totalWeight = totalWeight + item.weightItem;
    }

}