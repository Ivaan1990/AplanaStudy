package SecondTask.sweets;

/**
 * @author Ivan Yushin
 */
public class Chocolate extends Sweet {
    private static String[] varietys = {"молочный", "темный", "горький"};
    private String variety;

    /**
     *
     * @param price цена
     * @param weight вес
     * @param variety сорт шоколада
     * #see #variety
     */
    public Chocolate(double price, double weight, String variety) {
        super(price, weight);
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }

    /**
     *
     * @return рандомно возвращаем вкус шоколада
     * @see #varietys
     */
    public static String randomVariety() {
        return varietys[(int) (Math.random() * varietys.length)];
    }
    @Override
    public String toString() {
        return super.toString() + " шоколад. Сорт: " + variety;
    }
}