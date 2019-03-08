package SecondTask.sweets;

/**
 * @author Ivan Yushin
 */
public abstract class Sweet {
    private double price;
    private double weight;

    /**
     *
     * @param price цена
     * @param weight вес
     */
    public Sweet(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public static double getRandomWeight(){
        return  5 + (int) ((Math.random() * 40));
    }

    @Override
    public String toString() {
        return "Сладость";
    }
}