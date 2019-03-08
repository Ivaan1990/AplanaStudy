package SecondTask.sweets;

import java.util.Random;

public class Candy extends Sweet {

    private String color;

    public Candy(double price, double weight, String color) {
        super(price, weight);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " конфета";
    }

    public String getColor() {
        return color;
    }
}