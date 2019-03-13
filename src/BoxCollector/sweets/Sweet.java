package BoxCollector.sweets;

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
     * @param price цена
     * @param weight вес
     * @see #showErrorPrice
     */
    public Sweet(double price, double weight) {
        if(price < 0) {
            showErrorPrice();
        } else {
            this.price = price;
        }
        this.weight = weight;
    }

    /**
     *
     * @return цена сладости
     */
    public double getPrice() {
        try {
            return price;
        } catch (NullPointerException ex){
            ex.printStackTrace();
            return 0;
        }
    }

    /**
     * @return вес сладости
     */
    public double getWeight() {
        return weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight( double weight) {
        this.weight = weight;
    }

    /**
     *
     * @return возвращаем случайный вес сладости
     */
    public static double getRandomWeight(){
        return  5 + (int) ((Math.random() * 40));
    }

    /**
     *
     * @return возвращает случайный вкус сладости из массива tastes
     * @see #tastes
     */
    public static String randomTaste() {
        return tastes[(int) (Math.random() * tastes.length)];
    }

    /**
     * @see #Sweet(double price, double)
     * Выводит сообщение об ошибке ввода недопустимого значения для поля price
     */
    private void showErrorPrice(){
        System.err.println("ошибка при ввелении, price < 0");
        this.price = 0;
    }
}