package SecondTask;

import SecondTask.sweets.Sweet;

/**
 * @author Ivan Yushin
 * @see SweetsBox
 *
 */
public interface Box {
    Sweet get(int index);
    void add(Sweet sweet);
    void getInfoAboutSweets();
    void reduceWeight(int reduce);
    void reducePrice(int reduce);
    void delete(int index);
    double totalCostOfBox();
    double totalWeightOfBox();
    int size();
}