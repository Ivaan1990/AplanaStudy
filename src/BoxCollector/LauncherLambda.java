package BoxCollector;

import BoxCollector.sweets.Candy;
import BoxCollector.sweets.Chocolate;
import BoxCollector.sweets.Donut;
import BoxCollector.sweets.Sweet;

public class LauncherLambda {
    public static void main(String... args) {
        /** Список коробок с разными предикатами, раскоментировать коробку чтобы протестировать работу*/
        //Box box = new SweetsBox(sweet -> sweet instanceof Chocolate && sweet.getWeight() > 5); // только шоколадки весом больше 5
        Box box = new SweetsBox(); // любые сладости
        //Box box = new SweetsBox(sweet -> sweet.getPrice() < 2); // любые сладости дешевле 2 рублей

        /** @see FactorySweets * ----- 1 пункт задания ----- */

        //Создание вкусняшек через лямбды
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