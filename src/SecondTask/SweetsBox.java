package SecondTask;

import SecondTask.sweets.Sweet;

public class SweetsBox implements Box {

    private Sweet[] sweets;
    private int size;
    private int count;
    private static String[] tastes = {"strawberry", "apple", "banana", "orange"};

    public SweetsBox(int size) {
        sweets = new Sweet[size];
        this.size = size;
        count = 0;
    }

    @Override
    public void add(Sweet sweet) {
        sweets[count] = sweet;
        count++;
    }

    @Override
    public void delete(int index) {
        sweets[index] = null;
    }

    @Override
    public int size() {
        return sweets.length;
    }

    @Override
    public void getInfoAboutSweet(int index){
        System.out.println(
                sweets[index] + " его стоимость " + sweets[index].getPrice()
                + ", его вес " + sweets[index].getWeight()
        );
    }

    /**
     *
     * @return возвращает рандомный вкус сладости из массива colors
     * @see #tastes
     */
    public static String randomJuice() {
        return tastes[(int) (Math.random() * tastes.length)];
    }
}