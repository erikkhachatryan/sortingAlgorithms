package com.erik.sortingAlgorithms.merge;

import com.erik.sortingAlgorithms.common.BaseSortingAlgorithm;
import com.erik.sortingAlgorithms.common.SortingDirection;

/**
 * @Author Erik Khachatryan
 * @Date 16/03/2019
 */
public class MergeSortAlgorithm extends BaseSortingAlgorithm {

    public MergeSortAlgorithm(int arraySize, SortingDirection sortingDirection) {
        super(arraySize, sortingDirection);
    }

    @Override
    protected void runAlgorithm() {
        sortArrayPart(0, this.getArray().length - 1);
    }

    private void sortArrayPart(int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        //Sorts the first half of the array
        sortArrayPart(start, middle);
        //Sorts the second half of the array
        sortArrayPart(middle + 1, end);
        //Merges two sorted parts of the array into one
        merge(start, middle, end);
    }

    private void merge(int left, int middle, int right) {
        Integer[] leftSide = this.subArray(left, middle);
        Integer[] rightSide = this.subArray(middle + 1, right);
        int i = 0, j = 0;
        //Sets values in ordered sequence until one of the arrays get empty
        while (i < leftSide.length && j < rightSide.length) {
            this.setNewValue(left++, this.applySortingOperator(leftSide[i], rightSide[j]) ? leftSide[i++] : rightSide[j++]);
        }
        //Transfers remained elements from leftSide if any
        while (i < leftSide.length) {
            this.setNewValue(left++, leftSide[i++]);
        }
        //Transfers remained elements from rightSide if any
        while (j < rightSide.length) {
            this.setNewValue(left++, rightSide[j++]);
        }
    }

}
