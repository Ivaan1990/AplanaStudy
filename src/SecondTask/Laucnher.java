package SecondTask;

import SecondTask.sweets.Candy;
import SecondTask.sweets.Chocolate;
import SecondTask.sweets.Donut;
import SecondTask.sweets.Sweet;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Ivan Yushin
 * Изначальная ёмкость коробки 20, и больше этого значения быть не может, увеличение коробки не предусмотрено
 * В цикле рандомно создаем объекты сладостей, и добавляем их в коробку. Повторяем 20 раз
 * После того как коробка заполнена, сообщаем об этом, выводим её стоимость и общий вес
 * @see SweetsBox
 * @see Sweet
 * @see Box
 * @see #AMOUNT_OF_SWEETS (Candy, Donut, Chocolate,) количество видов сладостей
 */
public class Laucnher {
    private static final int AMOUNT_OF_SWEETS = 3;

    public static void main(String[] args) throws InterruptedException {

        while (true){
            Box box = new SweetsBox();
            System.out.println("Формируем коробку со сладостями");

            for(int i = 0; i < 10 + (Math.random() * 20); i++){
                Random r = new Random();
                int random = r.nextInt(AMOUNT_OF_SWEETS);
                switch (random){
                    case 0:
                        box.add(new Candy(1, Sweet.getRandomWeight(), Sweet.randomTaste()));
                        break;
                    case 1:
                        box.add(new Donut(3, Sweet.getRandomWeight(), Sweet.randomTaste()));
                        break;
                    case 2:
                        box.add(new Chocolate(4, Sweet.getRandomWeight(), Chocolate.randomVariety()));
                        break;
                }
            }

            System.out.println("Длина коробки " + box.size());
            System.out.println("Цена коробки со всеми сладостями " + box.totalCostOfBox());
            int totalWeight = (int)box.totalWeightOfBox();
            System.out.println("Общий вес " + totalWeight);

            int correctWeight = 400; // на какой вес корректируем

            if(totalWeight > correctWeight) {
                System.out.println("Сладости не влезли в коробку, идёт корректировка веса коробки");
                while (true){
                    box = box.reduceWeight(correctWeight);
                    if (box.totalWeightOfBox() < correctWeight){
                        break;
                    }
                }
                System.out.println("Корректировка веса прошла успешно.");
                System.out.println("Длина коробки " + box.size());
                System.out.println("Общий вес " + box.totalWeightOfBox());
            } else {
                System.out.println("Вес в норме");
            }

            int correctPrice = 40; // на какую цену корректируем

            if((int)box.totalCostOfBox() > correctPrice){
                System.out.println("Слишком дорого, корректируем цену коробки");
                while ((int)box.totalCostOfBox() > correctPrice){
                    box = box.reducePrice(correctPrice);
                }
                System.out.println("Цена скоректирована " + box.totalCostOfBox());
            } else {
                System.out.println("Цена в норме");
            }

            System.out.println("Подарок упакован, в него входит:");
            box.getInfoAboutSweets();
            System.out.println("Длина коробки " + box.size());
            Scanner sc = new Scanner(System.in);
            System.out.println("Хотите собрать ещё одну коробку ? введите q если нет");

            if(sc.nextLine().equalsIgnoreCase("q")){
                break;
            }
        }
    }
}