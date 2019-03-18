package com.erik.sortingAlgorithms.insertion;

import com.erik.sortingAlgorithms.common.BaseSortingAlgorithm;
import com.erik.sortingAlgorithms.common.SortingDirection;

/**
 * @Author Erik Khachatryan
 * @Date 16/03/2019
 */
public class InsertionSortAlgorithm extends BaseSortingAlgorithm {

    public InsertionSortAlgorithm(int arraySize, SortingDirection sortingDirection) {
        super(arraySize, sortingDirection);
    }

    @Override
    protected void runAlgorithm() {
        for (int i = 0; i < getArray().length; i++) {
            Integer currentValue = getValue(i);
            int j = i - 1;
            //Determines the position for currentValue, meanwhile swapping values to the right to free position for currentValue
            while (j > -1 && applySortingOperator(currentValue, getValue(j))) {
                swap(j + 1, j);
                --j;
            }
            setNewValue(j + 1, currentValue);
        }
    }
}
