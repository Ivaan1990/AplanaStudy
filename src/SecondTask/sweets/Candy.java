package SecondTask.sweets;

/**
 * @author Ivan Yushin
 */
public class Candy extends Sweet {
    private String taste;

    /**
     *
     * @param price цена
     * @param weight вес
     * @param taste вкус
     */
    public Candy(double price, double weight, String taste) {
        super(price, weight);
        this.taste = taste;
    }

    @Override
    public String toString() {
        return super.toString() + " конфета. Вкус: " + taste;
    }

    public String getTaste() {
        return taste;
    }
}