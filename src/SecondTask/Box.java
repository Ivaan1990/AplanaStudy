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
    Box reduceWeight(int reduce);
    Box reducePrice(int reduce);
    Box delete(int index);
    double totalCostOfBox();
    double totalWeightOfBox();
    int size();
}