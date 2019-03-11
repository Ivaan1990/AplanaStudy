package SecondTask;

import SecondTask.sweets.Sweet;

/**
 * @author Ivan Yushin
 * @see SweetsBox
 *
 */
public interface Box {
    void add(Sweet sweet);
    void delete(int index);
    Sweet get(int index);
    int size();
    void getInfoAboutSweets();
    double totalCostOfBox();
    double totalWeightOfBox();
    void reduceWeight(int reduce);
    void reducePrice(int reduce);
}