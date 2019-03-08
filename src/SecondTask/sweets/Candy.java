package SecondTask.sweets;

/**
 * @author Ivan Yushin
 */
public class Candy extends Sweet {

    private String color;

    /**
     *
     * @param price цена
     * @param weight вес
     * @param taste
     */
    public Candy(double price, double weight, String taste) {
        super(price, weight);
        this.color = taste;
    }

    @Override
    public String toString() {
        return super.toString() + " конфета";
    }

    public String getTaste() {
        return color;
    }
}