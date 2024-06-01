package sorting;

import java.util.Random;

public class SortComparison {

    public static void main(String[] args) {
        int size = 10000;
        int[] array = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }

        // 각 정렬 알고리즘을 위한 배열 복사본 생성
        int[] arrayBubble = array.clone();
        int[] arraySelection = array.clone();
        int[] arrayInsertion = array.clone();
        int[] arrayMerge = array.clone();
        int[] arrayQuick = array.clone();
        int[] arrayHeap = array.clone();
        int[] arrayTree = array.clone();
        int[] arrayTim = array.clone();

        // 각 정렬 알고리즘의 성능 측정 및 출력
        measurePerformance("Bubble Sort", arrayBubble, SortComparison::bubbleSort);
        measurePerformance("Selection Sort", arraySelection, SortComparison::selectionSort);
        measurePerformance("Insertion Sort", arrayInsertion, SortComparison::insertionSort);
        measurePerformance("Merge Sort", arrayMerge, (arr) -> mergeSort(arr, 0, arr.length - 1));
        measurePerformance("Quick Sort", arrayQuick, (arr) -> quickSort(arr, 0, arr.length - 1));
        measurePerformance("Heap Sort", arrayHeap, SortComparison::heapSort);
        measurePerformance("Tree Sort", arrayTree, SortComparison::treeSort);
        measurePerformance("Tim Sort", arrayTim, SortComparison::timSort);
    }

    /**
     * 성능을 측정하는 메서드
     *
     * @param sortName 정렬 알고리즘의 이름
     * @param array    정렬할 배열
     * @param sortAlgorithm 정렬 알고리즘을 나타내는 함수형 인터페이스
     */
    private static void measurePerformance(String sortName, int[] array, SortAlgorithm sortAlgorithm) {
        // Runtime 객체를 사용하여 메모리 사용량 측정
        Runtime runtime = Runtime.getRuntime();
        // 가비지 컬렉터 실행
        runtime.gc();
        // 초기 메모리 사용량 측정
        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        // 정렬 시작 시간 측정
        long startTime = System.nanoTime();

        // 정렬 알고리즘 실행
        sortAlgorithm.sort(array);

        // 정렬 종료 시간 측정
        long endTime = System.nanoTime();
        // 최종 메모리 사용량 측정
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        // 결과 출력
        System.out.printf("%s - Time: %d ns, Memory: %d bytes%n", sortName, (endTime - startTime), (endMemory - startMemory));
    }

    @FunctionalInterface
    interface SortAlgorithm {
        void sort(int[] array);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void treeSort(int[] arr) {
        BinarySearchTree bst = new BinarySearchTree();
        for (int num : arr) {
            bst.insert(num);
        }
        int[] index = {0};
        bst.inorderRec(bst.root, arr, index);
    }

    public static void timSort(int[] arr) {
        int RUN = 32;
        int n = arr.length;

        for (int i = 0; i < n; i += RUN)
            insertionSort(arr, i, Math.min((i + 31), (n - 1)));

        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                if (mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }

    static class BinarySearchTree {
        TreeNode root;

        BinarySearchTree() {
            root = null;
        }

        void insert(int key) {
            root = insertRec(root, key);
        }

        TreeNode insertRec(TreeNode root, int key) {
            if (root == null) {
                root = new TreeNode(key);
                return root;
            }
            if (key < root.val)
                root.left = insertRec(root.left, key);
            else if (key > root.val)
                root.right = insertRec(root.right, key);
            return root;
        }

        void inorderRec(TreeNode root, int[] arr, int[] index) {
            if (root != null) {
                inorderRec(root.left, arr, index);
                arr[index[0]++] = root.val;
                inorderRec(root.right, arr, index);
            }
        }
    }
}
