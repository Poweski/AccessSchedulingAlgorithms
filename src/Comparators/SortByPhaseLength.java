package Comparators;

import MyObjects.MyProcess;

import java.util.Comparator;

public class SortByPhaseLength implements Comparator<MyProcess> {
    public int compare(MyProcess a, MyProcess b) {
        return Integer.compare(a.getPhaseLength(), b.getPhaseLength());
    }
}
