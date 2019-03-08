package SecondTask.sweets;

/**
 * @author Ivan Yushin
 */
public class Donut extends Sweet {
    private String filling;

    /**
     *
     * @param price цена
     * @param weight вес
     * @param filling начинка
     */
    public Donut(double price, double weight, String filling) {
        super(price, weight);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    @Override
    public String toString() {
        return super.toString() + " пончик. Начинка: " + filling;
    }
}