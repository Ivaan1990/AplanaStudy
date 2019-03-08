package SecondTask;

import SecondTask.sweets.Candy;
import SecondTask.sweets.Chocolate;
import SecondTask.sweets.Donut;
import SecondTask.sweets.Sweet;

import java.util.Random;
import java.util.Scanner;

public class Laucnher {

    public static void main(String[] args) {

        Box box = new SweetsBox(20);
        System.out.println("Формируем ваш подарок");

        int boxSize = box.size();
        for(int i = 0; i < boxSize; i++){
            Random r = new Random();
            int random = r.nextInt(3);
            switch (random){
                case 0:
                    box.add(new Candy(1, 2, SweetsBox.randomJuice()));
                    break;
                case 1:
                    box.add(new Donut(1, 40, SweetsBox.randomJuice()));
                    break;
                case 2:
                    box.add(new Chocolate(2, 60, SweetsBox.randomJuice()));
                    break;
            }
        }
        System.out.println("Подарок сформирован");
        for (int i = 0; i < boxSize; i++) {
            box.getInfoAboutSweet(i);
        }

    }
}