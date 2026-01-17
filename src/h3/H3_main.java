package h3;

import java.util.Arrays;

public class H3_main {
    public static void main(String[] args) {
        int[] array = {9, 3, 7, 1, 5, 2, 8, 4, 6};
        System.out.println("Unsortiert: " + Arrays.toString(array));
        int[] sorted = mergeSort(array);
        System.out.println("Sortiert: " + Arrays.toString(sorted));
    }

    public static int[] mergeSort(int[] list) {
        if (list.length <= 1) return list;

        int[] leftList = Arrays.copyOfRange(list, 0, list.length / 2);
        int[] rightList = Arrays.copyOfRange(list, list.length / 2, list.length);

        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        return merge(leftList, rightList);
    }

    private static int[] merge(int[] leftList, int[] rightList) {
        int[] mergeList = new int[leftList.length + rightList.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        while (leftIndex < leftList.length && rightIndex < rightList.length) {

            if (leftList[leftIndex] <= rightList[rightIndex]) {
                mergeList[mergeIndex] = leftList[leftIndex];
                leftIndex++;
            } else if (rightList[rightIndex] < leftList[leftIndex]) {
                mergeList[mergeIndex] = rightList[rightIndex];
                rightIndex++;
            }

            mergeIndex++;

        }

        if(mergeIndex < mergeList.length) {

            while(leftIndex < leftList.length) {
                mergeList[mergeIndex] = leftList[leftIndex];
                mergeIndex++;
                leftIndex++;
            }
            while(rightIndex < rightList.length) {
                mergeList[mergeIndex] = rightList[rightIndex];
                mergeIndex++;
                rightIndex++;
            }

        }

        return mergeList;
    }
}
