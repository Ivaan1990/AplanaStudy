package SecondTask.sweets;

/**
 * @author Ivan Yushin
 */
public class Chocolate extends Sweet {
    private static String[] variety = {"молочный", "темный", "горький"};
    private String taste;

    /**
     *
     * @param price
     * @param weight
     * @param taste вкус шоколада
     * #see #variety
     */
    public Chocolate(double price, double weight, String taste) {
        super(price, weight);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }

    /**
     *
     * @return рандомно вовзвращаем вкус шоколада
     * @see #variety
     */
    public static String randomTaste() {
        return variety[(int) (Math.random() * variety.length)];
    }
    @Override
    public String toString() {
        return super.toString() + " шоколад " + taste;
    }
}
