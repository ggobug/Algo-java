package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // 1. 0번째 인덱스부터 탐색
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                // 2. 최소값을 가지는 인덱스 선택
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // 3. 선택한 인덱스와 스왑
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
