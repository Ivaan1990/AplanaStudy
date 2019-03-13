package BoxCollector;

import BoxCollector.sweets.Sweet;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Ivan Yushin
 * -------------------
 * @see Box
 */

public class SweetsBox implements Box {
    private List<Sweet> sweets = new ArrayList<>();
    private Predicate<Sweet> predicate = null;

    public SweetsBox() {}

    /**
     * @param predicate
     */
    public SweetsBox(Predicate<Sweet> predicate){
        this.predicate = predicate;
    }

    public List<Sweet> getSweets() {
        return sweets;
    }

    /**
     * @param sweet добавляем объект сладости в массив sweets, т.е кладём в коробку
     * @see #sweets
     * @see #predicate проверка на null в случае создания коробки без предиката
     */
    @Override
    public void add(Sweet sweet) {
        if(predicate == null){
            sweets.add(sweet);
        } else {
            if (predicate.test(sweet)) {
                sweets.add(sweet);
            } else {
                System.out.println("нельзя добавить сладость");
            }
        }
    }

    /**
     * @param index удаляем сладость из коробки по её индексу
     */
    @Override
    public void delete(int index){
        sweets.remove(index);
    }

    /**
     * @return возвращает длину коробки
     * @see #size
     */
    @Override
    public int size() {
        return sweets.size();
    }

    @Override
    public Sweet get(int index) {
        return sweets.get(index);
    }

    /**
     * вся инфорация по коробке, выводит в консоль содержимое коробки
     * @see Sweet
     */
    @Override
    public void getInfoAboutSweets(){
        System.out.println("Содержимое коробки:");
        sweets.forEach(System.out::println);
        System.out.println("Сладостей в коробке " + sweets.size());
    }

    /**
     * @return общую стоимость коробки
     */
    @Override
    public double totalCostOfBox() {
        return sweets
                .stream()
                .mapToDouble(Sweet::getPrice)
                .sum();
    }

    /**
     * @return общий вес коробки
     */
    @Override
    public double totalWeightOfBox() {
        return sweets
                .stream()
                .mapToDouble(Sweet::getWeight)
                .sum();
    }

    /**
     *
     * @param predicate предикат, сладость которую хотим подсчитать в коробке
     * TODO требуется доработка, внутри метода надо понять какую сладость считаем, узнать какую можно только через параметр в main
     */
    @Override
    public void howMuchSweetInBox(Predicate<Sweet> predicate){
        System.out.println(sweets
                .stream()
                .filter(predicate)
                .count());
    }

    /**
     * @param reduce изменяем вес коробки, на тот вес что передается в параметр метода
     *  Находим самый тяжелую сладость и убираем ее из массива
     */
    @Override
    public void reduceWeight(int reduce) {
        try {
            int maxWeight = 0;
            int index = 0;
            for(int i = 0; i < sweets.size(); i++){
                int weight = (int)sweets.get(i).getWeight();
                if (maxWeight < weight){
                    maxWeight = weight;
                    index = i;
                }
            }
            int total = (int)this.totalWeightOfBox();
            if (total > reduce){
                delete(index);
            }
        } catch (NullPointerException ex){
            System.out.print("в методе reduceWeight null");
        }
    }

    /**
     * @param reduce изменяем цену коробки, на ту цену что передается в параметр метода
     *  путем извлечения самых дорогих сладостей
     */
    @Override
    public void reducePrice(int reduce) {
        try{
            int max = 0;
            int index = 0;
            for(int i = 0; i < sweets.size() - 1; i++){
                int price = (int)sweets.get(i).getPrice();
                if (max < price){
                    max = price;
                    index = i;
                }
            }
            int total = (int)this.totalCostOfBox();
            if (total > reduce){
                delete(index);
            }
        } catch (NullPointerException ex){
            System.out.print("в методе reducePrice null");
        }
    }
}