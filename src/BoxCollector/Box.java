package BoxCollector;

import BoxCollector.sweets.Sweet;

import java.util.function.Predicate;

/**
 * @author Ivan Yushin
 * @see SweetsBox
 *
 */
public interface Box {
    void add(Sweet sweet);
    void delete(int index);
    int size();
    void getInfoAboutSweets();
    double totalCostOfBox();
    double totalWeightOfBox();
    void reduceWeight(int reduce);
    void reducePrice(int reduce);
    void howMuchSweetInBox(Predicate<Sweet> sweetPredicate);
    Sweet get(int index);
}