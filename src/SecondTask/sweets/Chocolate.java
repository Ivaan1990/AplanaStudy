package SecondTask.sweets;

public class Chocolate extends Sweet {

    private String taste;

    public Chocolate(double price, double weight, String taste) {
        super(price, weight);
        this.taste = taste;
    }

    @Override
    public String toString() {
        return super.toString() + " шоколад";
    }

    public String getTaste() {
        return taste;
    }
}
