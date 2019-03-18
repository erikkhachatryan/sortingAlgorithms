package com.erik.sortingAlgorithms.counting;

import com.erik.sortingAlgorithms.common.BaseSortingAlgorithm;
import com.erik.sortingAlgorithms.common.SortingDirection;

/**
 * @Author Erik Khachatryan
 * @Date 16/03/2019
 */
public class CountingSortAlgorithm extends BaseSortingAlgorithm {

    private final int[] indexesArray;
    private final Integer[] arrayCopy;

    public CountingSortAlgorithm(int arraySize, SortingDirection sortingDirection) {
        super(arraySize, sortingDirection);
        indexesArray = new int[MAX_VALUE_TO_GENERATE + 1];
        arrayCopy = subArray(0, getArray().length - 1);
    }

    @Override
    protected void runAlgorithm() {
        //Determines each value repetition counts
        for (Integer element : arrayCopy) {
            indexesArray[element]++;
        }
        //Determines from which index each value must start from
        if (sortingDirection.equals(SortingDirection.ASCENDING)) {
            for (int i = 1; i < indexesArray.length; i++) {
                indexesArray[i] += indexesArray[i - 1];
            }
        } else {
            for (int i = indexesArray.length - 2; i >= 0; i--) {
                indexesArray[i] += indexesArray[i + 1];
            }
        }
        //Sets each value in it's position and decrements corresponding index in indexesArray for next repetition of that value
        for (int i = arrayCopy.length - 1; i >= 0; i--) {
            setNewValue(indexesArray[arrayCopy[i]] - 1, arrayCopy[i]);
            indexesArray[arrayCopy[i]]--;
        }
    }
}
