package org.work.algoritms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(getTarget(arr, 10));
        System.out.println(getTarget(arr2, 14));

    }

    public static List<String> getTarget(int[] array, int target) {
        List<String> list = new ArrayList<>();
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = length - 1; j > length / 2 - 1; j--) {
                if (array[i] + array[j] == target) {
                    String string = array[i] + " и " + array[j];
                    list.add(string);
                }
            }
        }
        return list;
    }
}
