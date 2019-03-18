package com.erik.sortingAlgorithms.quick;

import com.erik.sortingAlgorithms.common.BaseSortingAlgorithm;
import com.erik.sortingAlgorithms.common.SortingDirection;

/**
 * @Author Erik Khachatryan
 * @Date 16/03/2019
 */
public class QuickSortAlgorithm extends BaseSortingAlgorithm {

    public QuickSortAlgorithm(int arraySize, SortingDirection sortingDirection) {
        super(arraySize, sortingDirection);
    }

    @Override
    protected void runAlgorithm() {
        quickSort(0, getArray().length - 1);
    }

    private void quickSort(int start, int end) {
        if (start == end) {
            return;
        }
        int left = start;
        int right = end;
        int pivotIndex = left + (right - left) / 2;
        Integer pivot = getValue(pivotIndex);
        while (left <= right) {
            //Finds out which element should be in the opposite side of pivot
            while (applySortingOperator(getValue(left), pivot)) {
                ++left;
            }
            //Finds out which element should be in the opposite side of pivot
            while (applySortingOperator(pivot, getValue(right))) {
                --right;
            }
            //Swaps 2 elements positions
            if(left <= right) {
                swap(left, right);
                ++left;
                --right;
            }
        }
        //Repeats the algorithm for left side if any
        if (start < right) {
            quickSort(start, right);
        }
        //Repeats the algorithm for right side if any
        if (left < end) {
            quickSort(left, end);
        }
    }
}
