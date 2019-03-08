package SecondTask.sweets;


/**
 * @author Ivan Yushin
 * @see Candy
 * @see Chocolate
 * @see Donut
 */
public abstract class Sweet {
    private double price;
    private double weight;
    private static String[] tastes = {"клубника", "яблоко", "банан", "апельсин"};

    /**
     *
     * @param price цена
     * @param weight вес
     */
    public Sweet(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    /**
     *
     * @return цена сладости
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return вес сладости
     */
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Сладость";
    }

    /**
     *
     * @return возвращаем рандомный вес сладости
     */
    public static double getRandomWeight(){
        return  5 + (int) ((Math.random() * 40));
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