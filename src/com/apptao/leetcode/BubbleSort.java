package com.apptao.leetcode;

/**
 * Created by a on 2017-12-25.
 */
public class BubbleSort
{
    public static void main(String[] args) {
        int[] ints = {3, 4, 56, 12, 32, 453, 23, 44, 32, 11, 1};
        bubblesort(ints);
    }

    public static void bubblesort(int[] arr) {

        int length = arr.length;
        int i, temp;
        boolean changed;
        do {
        changed = false;
            for (i = 0; i < length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    changed = true;
                }
            }
        } while (changed);
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);

        }
    }
}
