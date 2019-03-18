package com.erik.sortingAlgorithms;

import com.erik.sortingAlgorithms.bubble.BubbleSortAlgorithm;
import com.erik.sortingAlgorithms.common.BaseSortingAlgorithm;
import com.erik.sortingAlgorithms.common.SortingDirection;
import com.erik.sortingAlgorithms.counting.CountingSortAlgorithm;
import com.erik.sortingAlgorithms.insertion.InsertionSortAlgorithm;
import com.erik.sortingAlgorithms.merge.MergeSortAlgorithm;
import com.erik.sortingAlgorithms.quick.QuickSortAlgorithm;

/**
 * @Author Erik Khachatryan
 * @Date 16/03/2019
 */
public class Main {

    public static void main(String[] args) {
        BaseSortingAlgorithm sortingAlgorithm = new QuickSortAlgorithm(10, SortingDirection.ASCENDING);
        sortingAlgorithm.print();
        long durationInNanoSeconds = sortingAlgorithm.sort();
        System.out.println("Algorithm last " + durationInNanoSeconds + " nano seconds.");
        sortingAlgorithm.print();
    }

}
