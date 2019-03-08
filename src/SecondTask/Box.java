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
    void delete(int index);
    int size();
    void getInfoAboutSweets();
    double totalCostOfBox();
    double totalWeightOfBox();
    void reduceWeight(int reduce);
}