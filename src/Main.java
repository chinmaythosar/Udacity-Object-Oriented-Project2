import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello World!");

        Simulation temp1 = new Simulation();
        Simulation temp2 = new Simulation();


        ArrayList tempArr1 = temp1.loadItems("Phase-1.txt");

        ArrayList tempArr2 = temp2.loadItems("Phase-2.txt");

        System.out.println("U1 :" + (temp1.runSimulation(temp1.loadU1(tempArr1)) + temp2.runSimulation(temp2.loadU1(tempArr2))));

        System.out.println("U2 :" + (temp1.runSimulation(temp1.loadU2(tempArr1)) + temp2.runSimulation(temp2.loadU2(tempArr2))));

    }

    public interface Spaceship{
        public boolean launch();
        public boolean land();
        public boolean canCarry(Item item);
        public void carry(Item item);
    }

}
