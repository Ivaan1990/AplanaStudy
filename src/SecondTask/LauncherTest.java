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
        box.add(null);
        try {
            System.out.println(box.get(0).getPrice());
        } catch (NullPointerException ex){
            System.out.println("2");
        }
        /*System.out.println("weight = " + box.totalWeightOfBox());
        System.out.println("size = " + box.size());

        int count = 0;
        while (box.totalWeightOfBox() > 0){
            box.reducePrice(0);

        }
        System.out.println(count);
        System.out.println("weight = " + box.totalWeightOfBox());
        System.out.println("size = " + box.size());*/
    }
}