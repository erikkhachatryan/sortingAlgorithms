package com.erik.sortingAlgorithms.common;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author Erik Khachatryan
 * @Date 16/03/2019
 */
public abstract class BaseSortingAlgorithm {

    protected final Integer MAX_VALUE_TO_GENERATE = 100;
    private final Integer[] array;
    private LocalTime startTime;
    private LocalTime endTime;
    private final Random randomNumberGenerator;
    protected final SortingDirection sortingDirection;

    public BaseSortingAlgorithm(int arraySize, SortingDirection sortingDirection) {
        this.array = new Integer[arraySize];
        this.sortingDirection = sortingDirection;
        randomNumberGenerator = new Random();
        this.fillArrayWithRandomNumbers();
    }

    private void fillArrayWithRandomNumbers() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = this.randomNumberGenerator.nextInt(MAX_VALUE_TO_GENERATE);
        }
    }

    private long getDuration() {
        return this.endTime.toNanoOfDay() - this.startTime.toNanoOfDay();
    }

    protected abstract void runAlgorithm();

    protected final void swap(int index1, int index2) {
        int temp = this.array[index1];
        this.array[index1] = this.array[index2];
        this.array[index2] = temp;
    }

    protected final void setNewValue(int index, Integer value) {
        this.array[index] = value;
    }

    protected final Integer getValue(int index) {
        return this.array[index];
    }

    protected final Integer[] subArray(int left, int right) {
        int size = right - left + 1;
        Integer[] subArray = new Integer[size];
        for (int j = 0, i = left; i <= right; i++, j++) {
            subArray[j] = this.array[i];
        }
        return subArray;
    }
    protected boolean applySortingOperator(Integer first, Integer second) {
        return this.sortingDirection.equals(SortingDirection.ASCENDING) ? first < second : first > second;
    }

    public final long sort() {
        this.startTime = LocalTime.now();
        runAlgorithm();
        this.endTime = LocalTime.now();
        return this.getDuration();
    }

    public final Integer[] getArray() {
        return this.array;
    }

    public void print() {
        System.out.println(Arrays.toString(this.array));
    }

}
