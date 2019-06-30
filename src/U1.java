import java.util.*;

public class U1 extends Rocket{
    double chance=0;
    int rocketCost = 100;
    Random random = new Random();

    double totalWeight = 10;
    double weightLimit = 18;


    public boolean launch(){

        this.chance = 0.05 * (this.totalWeight/this.weightLimit);

        return !(random.nextFloat() < this.chance);
    }

    public boolean land(){

        this.chance = 0.01 * (this.totalWeight/this.weightLimit);

        return !(random.nextFloat() < this.chance);
    }

}
