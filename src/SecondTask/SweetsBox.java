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
    private Sweet[] sweets;
    private int count = 0;

    /**
     * Конструктор - создание пустой коробки
     */
    public SweetsBox() {
        sweets = new Sweet[count];
    }

    /**
     *
     * @param sweet добавляем объект сладости в массив sweets, т.е кладём в коробку
     * @see #sweets
     */
    @Override
    public void add(Sweet sweet) {
        try {
            sweets = Arrays.copyOf(sweets, sweets.length + 1);
            sweets[count++] = sweet;
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.print("в методе add ArrayIndexOutOfBoundsException");
        }
    }

    /**
     *
     * @param index удаляем сладость из коробки по её индексу
     * @return возвращает новый экземпляр коробки без этого элемента
     */
    @Override
    public void delete(int index) {
        try {
            Sweet[] temp = new Sweet[size() - 1];
            if (index >= this.size() || index < 0) {
                System.err.println("Невозможно удалить не существующий элемент");
            } else {
                for (int i = 0; i < size() - 1; i++) {
                    if (i != index) {
                        temp[i] = sweets[i];
                    } else {
                        temp[i] = sweets[size() - 1];
                    }
                }
                sweets = temp;
            }
        } catch (NullPointerException ex){
            System.out.print("в методе delete null");
        }
    }

    /**
     *
     * @param index извлекаем сладость по его индексу
     * @return возвращаем объект подкласса Sweet
     * @err выводит сообщение о ошибке, заменяется введённый индекс на 0
     */
    @Override
    public Sweet get(int index) {
        if (index > size() || index < 0){
            System.err.println("Такого индекса нет");
            index = 0;
        }
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
            System.out.print("в методе getInfoAboutSweets null");
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
            System.out.print("в методе totalCostOfBox null");
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
            System.out.print("в методе totalWeightOfBox null");
        }
        return totalWeight;
    }

    /**
     *
     * @param reduce изменяем вес коробки, на тот вес что передается в параметр метода
     *  Находим самый тяжелую сладость и убираем ее из массива
     */
    @Override
    public void reduceWeight(int reduce) {
        try {
            int maxWeight = 0;
            int index = 0;
            for(int i = 0; i < sweets.length; i++){
                int weight = (int)sweets[i].getWeight();
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
     *
     * @param reduce изменяем цену коробки, на ту цену что передается в параметр метода
     *  путем извлечения любых сладостей
     */
    @Override
    public void reducePrice(int reduce) {
        try{
            int max = 0;
            int index = 0;
            for(int i = 0; i < sweets.length - 1; i++){
                int price = (int)sweets[i].getPrice();
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