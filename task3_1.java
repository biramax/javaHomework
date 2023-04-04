/*
Реализовать алгоритм сортировки слиянием и выборкой.
(Самое эффективное, это тзучить эти сортировки на Питоне , и постораться написать их на java)
*/

import java.util.Arrays;

public class task3_1 {

    public static int[] initialArr = {3, 28, 1, 16, 9, 2};

    public static void main(String[] args) {
        
        // Сортировка выборкой
        int[] arr1 = Arrays.copyOf(initialArr, initialArr.length);        
        selectionSort(arr1);
        for (int item : arr1)
            System.out.print(item + " ");
        System.out.println();

        // Сортировка слиянием
        int[] arr2 = Arrays.copyOf(initialArr, initialArr.length);
        mergeSort(arr2, 0, arr2.length - 1);
        for (int item : arr2)
            System.out.print(item + " ");
        System.out.println();
    }


    // Сортировка выборкой

    /* На Python
    for i in range(len(arr)):
        min_index = i
        for j in range(i+1, len(arr)):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]
    */
    public static int[] selectionSort(int[] arr) {
                
        int minIndex, temp;
        for (int i = 0; i < arr.length; i ++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j ++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
        return arr;
    }


    // Сортировка слиянием

    /* На Python
    def merge_sort(arr):
        if len(arr) > 1:
            middle_index = len(arr) // 2
            left_half = arr[:middle_index]
            right_half = arr[middle_index:]
            merge_sort(left_half)
            merge_sort(right_half)
            i = j = k = 0
            while i < len(left_half) and j < len(right_half):
                if left_half[i] < right_half[j]:
                    arr[k] = left_half[i]
                    i += 1
                else:
                    arr[k] = right_half[j]
                    j += 1
                k += 1
            while i < len(left_half):
                arr[k] = left_half[i]
                i += 1
                k += 1
            while j < len(right_half):
                arr[k] = right_half[j]
                j += 1
                k += 1
        return arr
    */

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (int m = 0; m < temp.length; m++) {
            arr[left + m] = temp[m];
        }
    }
}
