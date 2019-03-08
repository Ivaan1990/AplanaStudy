package SecondTask;

import SecondTask.sweets.Candy;
import SecondTask.sweets.Sweet;

/**
 * @author Ivan Yushin
 * @see #reduceWeight(int) TODO
 * @see Box
 */
public class SweetsBox implements Box {

    private Sweet[] sweets;
    private int size;
    private int count;
    private static String[] tastes = {"strawberry", "apple", "banana", "orange"};

    /**
     * Конструктор - создание нового объекта
     * @param size длина массива
     */
    public SweetsBox(int size) {
        sweets = new Sweet[size];
        this.size = size;
        count = 0;
    }

    /**
     *
     * @param sweet добавляем объект сладости в массив sweets, т.е кладём в коробку
     * @see #sweets
     */
    @Override
    public void add(Sweet sweet) {
        sweets[count] = sweet;
        count++;
    }

    /**
     *
     * @param index удаляем сладость из коробки по её индексу
     */
    @Override
    public void delete(int index) {
        sweets[index] = null;
    }

    /**
     *
     * @param index извлекаем сладость по его индексу
     * @return возвращаем объект подкласса Sweet
     */
    @Override
    public Sweet get(int index) {
        return sweets[index];
    }

    /**
     *
     * @return возвращает длину коробки
     * @see #size
     */
    @Override
    public int size() {
        return sweets.length;
    }

    /**
     * вся инфорация по подарку, выводит в консоль:
     * что за сладость
     * её стоимость
     * её вес
     */
    @Override
    public void getInfoAboutSweets(){
        for(Sweet sweet : sweets){
            System.out.println(
                    sweet + " его стоимость " + sweet.getPrice()
                            + ", его вес " + sweet.getWeight()
            );
        }
    }

    /**
     *
     * @return общую стоимость подарка
     */
    @Override
    public double totalCostOfBox() {
        double sum = 0;
        for (Sweet sweet : sweets) {
            sum += sweet.getPrice();
        }
        return sum;
    }

    /**
     *
     * @return общий вес коробки
     */
    @Override
    public double totalWeightOfBox() {
        double totalWeight = 0;
        for (Sweet sweet : sweets){
            totalWeight += sweet.getWeight();
        }
        return totalWeight;
    }

    /**
     *
     * @param reduce изменяем вес коробки, на тот вес что передается в параметр метода
     */
    @Override
    public void reduceWeight(int reduce) {

        int total = (int)totalWeightOfBox();
        int min = 0;
        int index = 0;

        for(int i = 0; i < sweets.length; i++){
            if(sweets[i].getWeight() < min){
                min = (int)sweets[i].getWeight();
                index = i;
                System.out.println(min);
            }
            int correct = total - min;

        }

        //getInfoAboutSweets();
        System.out.println(min);
    }

    /**
     *
     * @return возвращает рандомный вкус сладости из массива tastes
     * @see #tastes
     */
    public static String randomTaste() {
        return tastes[(int) (Math.random() * tastes.length)];
    }

}