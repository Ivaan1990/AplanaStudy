package SecondTask;

import SecondTask.sweets.Sweet;

public interface Box {
    void add(Sweet sweet);
    void delete(int index);
    int size();
    void getInfoAboutSweet(int index);
}