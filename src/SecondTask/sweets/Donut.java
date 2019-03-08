package SecondTask.sweets;

public class Donut extends Sweet {

    private String filling;

    public Donut(double price, double weight, String filling) {
        super(price, weight);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    @Override
    public String toString() {
        return super.toString() + " пончик";
    }
}