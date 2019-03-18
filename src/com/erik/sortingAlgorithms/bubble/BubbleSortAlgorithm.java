package com.erik.sortingAlgorithms.bubble;

import com.erik.sortingAlgorithms.common.BaseSortingAlgorithm;
import com.erik.sortingAlgorithms.common.SortingDirection;

/**
 * @Author Erik Khachatryan
 * @Date 16/03/2019
 */
public class BubbleSortAlgorithm extends BaseSortingAlgorithm {

    public BubbleSortAlgorithm(int arraySize, SortingDirection sortingDirection) {
        super(arraySize, sortingDirection);
    }

    @Override
    protected void runAlgorithm() {
        //For each value swaps with next value until it gets in it's right position in array
        for (int i = 0; i < getArray().length; i++) {
            for (int j = i + 1; j < getArray().length; j++) {
                if (applySortingOperator(getValue(j), getValue(i))) {
                    swap(i, j);
                }
            }
        }
    }
}
