import java.util.Random;

public class U2 extends Rocket{
    double chance=0;
    int rocketCost = 120;
    Random random = new Random();

    double totalWeight = 18;
    double weightLimit = 29;


    public boolean launch(){

        this.chance = 0.04 * (this.totalWeight/this.weightLimit);

        return !(random.nextFloat() < this.chance);
    }

    public boolean land(){

        this.chance = 0.08 * (this.totalWeight/this.weightLimit);

        return !(random.nextFloat() < this.chance);
    }

}