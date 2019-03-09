package SecondTask;
import SecondTask.sweets.Sweet;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Ivan Yushin
 * ---- Smart Box ----
 * @see #reduceWeight(int)
 * @see #reducePrice(int)
 * -------------------
 * @see Box
 */

public class SweetsBox implements Box {
    private Sweet[] sweets = null;
    private int count = 0;

    /**
     * Конструктор - создание нового объекта
     *
     */
    public SweetsBox() {
        sweets = new Sweet[1];
    }

    /**
     *
     * @param sweet добавляем объект сладости в массив sweets, т.е кладём в коробку
     * @see #sweets
     */
    @Override
    public void add(Sweet sweet) {
        sweets[count++] = sweet;
        sweets = Arrays.copyOf(sweets, sweets.length + 1);
    }

    /**
     *
     * @param index удаляем сладость из коробки по её индексу
     * @return возвращает новый экземпляр коробки без этого элемента
     */
    @Override
    public Box delete(int index) {
        Box temp = new SweetsBox();
        if (index >= this.size() || index < 0) {
            System.err.println("Невозможно удалить не существующий элемент");
        } else {
            for (int i = 0; i < size(); i++) {
                if (i == index) {
                    continue;
                } else {
                    temp.add(sweets[i]);
                }
            }
        }
        return temp;
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
        return sweets.length - 1;
    }

    /**
     * вся инфорация по подарку, выводит в консоль:
     * что за сладости, их стоимость и вес
     * @see Sweet
     */
    @Override
    public void getInfoAboutSweets(){
        try{
            for(Sweet sweet : sweets){
                System.out.println(
                        sweet + ". Стоимость " + sweet.getPrice()
                                + ", вес " + sweet.getWeight()
                );
            }
        } catch (NullPointerException ex){
            System.out.print("");
        }
    }

    /**
     *
     * @return общую стоимость подарка
     */
    @Override
    public double totalCostOfBox() {
        double sum = 0;
        try {
            for (Sweet sweet : sweets) {
                double d = sweet.getPrice();
                sum += d;
            }
        } catch (NullPointerException ex){
            System.out.print("");
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
        try {
            for (Sweet sweet : sweets){
                totalWeight += sweet.getWeight();
            }
        } catch (NullPointerException ex){
            System.out.print("");
        }

        return totalWeight;
    }

    /**
     *
     * @param reduce изменяем вес коробки, на тот вес что передается в параметр метода
     *  Находим самый тяжелую сладость и убираем ее из массива
     *  @return новую коробку из которой убрано самая весомая сладость
     */
    @Override
    public Box reduceWeight(int reduce) {
        Box temp = new SweetsBox();
        try{
            int max = 0;
            int index = 0;

            for(int i = 0; i < sweets.length - 1; i++){
                temp.add(sweets[i]);
                int weight = (int)sweets[i].getWeight();
                if (max < weight){
                    max = weight;
                    index = i;
                }
            }
            int total = (int)temp.totalWeightOfBox();

            if (total > reduce){
                temp = temp.delete(index);
            }
        } catch (NullPointerException ex){
            System.out.print("");
        }

        return temp;
    }

    /**
     *
     * @param reduce изменяем цену коробки, на ту цену что передается в параметр метода
     *  путем извлечения любых сладостей
     * @return новую коробку из которой убрано самое дорогая сладость
     */
    @Override
    public Box reducePrice(int reduce) {
        Box temp = new SweetsBox();
        try{
            int max = 0;
            int index = 0;

            for(int i = 0; i < sweets.length - 1; i++){
                temp.add(sweets[i]);
                int weight = (int)sweets[i].getPrice();
                if (max < weight){
                    max = weight;
                    index = i;
                }
            }
            int total = (int)temp.totalCostOfBox();

            if (total > reduce){
                temp = temp.delete(index);
            }
        } catch (NullPointerException ex){
            System.out.print("");
        }

        return temp;
    }
}