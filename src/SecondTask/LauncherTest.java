package SecondTask;

import SecondTask.Box;
import SecondTask.SweetsBox;
import SecondTask.sweets.Candy;
import SecondTask.sweets.Chocolate;
import SecondTask.sweets.Donut;
import SecondTask.sweets.Sweet;

public class LauncherTest {
    public static void main(String[] args) throws InterruptedException {
        Box box = new SweetsBox();
        box.add(new Chocolate(3, 10, "молочный"));
        box.add(new Chocolate(1, 10, "темный"));
        box.add(new Chocolate(1, 10, "темный"));
        box.add(new Chocolate(1, 10, "темный"));
        box.add(new Chocolate(1, 10, "горький"));
        System.out.println("weight = " + box.totalWeightOfBox());
        System.out.println("size = " + box.size());

        int count = 0;
        while (box.totalWeightOfBox() > 0){
            box.reducePrice(0);

        }
        System.out.println(count);
        System.out.println("weight = " + box.totalWeightOfBox());
        System.out.println("size = " + box.size());
    }
}