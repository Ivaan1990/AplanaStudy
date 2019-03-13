package BoxCollector;

import BoxCollector.sweets.Candy;
import BoxCollector.sweets.Chocolate;
import BoxCollector.sweets.Donut;
import BoxCollector.sweets.Sweet;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Ivan Yushin
 *
 * Изначальная ёмкость коробки 20, и больше этого значения быть не может, увеличение коробки не предусмотрено
 * В цикле рандомно создаем объекты сладостей, и добавляем их в коробку. Повторяем 20 раз
 * После того как коробка заполнена, сообщаем об этом, выводим её стоимость и общий вес
 * @see SweetsBox
 * @see Sweet
 * @see Box
 * @see #AMOUNT_OF_SWEETS Candy, Donut, Chocolate количество видов сладостей
 */
public class Laucnher {
    private static final int AMOUNT_OF_SWEETS = 3;

    public static void main(String[] args) throws InterruptedException {

        /** Список коробок с разными предикатами, раскоментировать коробку чтобы протестировать работу*/
        //Box box = new SweetsBox(sweet -> sweet instanceof Chocolate && sweet.getWeight() > 5); // только шоколадки весом больше 5
        Box box = new SweetsBox(); // любые сладости
        //Box box = new SweetsBox(sweet -> sweet.getPrice() < 2); // любые сладости дешевле 2 рублей

        /** @see FactorySweets * ----- 1 пункт задания ----- */

        //Создание вкусняшек через статические ссылки на методы
        FactorySweets<Sweet> candyFactory = Candy::new;
        box.add(candyFactory.create(2, Sweet.getRandomWeight(), Candy.randomTaste()));
        FactorySweets<Sweet> chocolateFactory = Donut::new;
        box.add(chocolateFactory.create(2, Sweet.getRandomWeight(), Candy.randomTaste()));

        //через фабрику отдельных классов
        FactorySweets<Sweet> oneCandy = new FactorySweets<Sweet>() {
            @Override
            public Sweet create(double price, double weight, String taste) {
                return new Candy(price, weight, taste);
            }
        };

        FactorySweets<Sweet> oneDonut = new FactorySweets<Sweet>() {
            @Override
            public Sweet create(double price, double weight, String taste) {
                return new Chocolate(price, weight, taste);
            }
        };

        box.add(oneCandy.create(2, Sweet.getRandomWeight(), Sweet.randomTaste()));
        box.add(oneDonut.create(4, Sweet.getRandomWeight(), Sweet.randomTaste()));

        /** 4 пункт задания */
        box.getInfoAboutSweets();
        System.out.println("------------------------");
        System.out.println("Общая стоимость коробки " + box.totalCostOfBox());
        System.out.println("Общий вес коробки " + box.totalWeightOfBox());
        box.howMuchSweetInBox(sweet -> sweet instanceof Candy);
        System.out.println("------------------------");

        /** 2 пункт задания */
    }
}