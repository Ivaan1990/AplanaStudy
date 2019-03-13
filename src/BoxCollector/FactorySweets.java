package BoxCollector;

import BoxCollector.sweets.Sweet;

@FunctionalInterface
public interface FactorySweets<P extends Sweet> {
    P create(double price, double weight, String taste);
}
