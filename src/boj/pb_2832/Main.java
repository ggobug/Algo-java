package boj.pb_2832;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] segTree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        segTree = new int[4 * N];
        buildSegmentTree(0, N - 1, 1);
        int reverseCount = 0;
        while (!isNonDecreasing()) {
            reverseCount += reverseSlopes();
        }
        System.out.println(reverseCount);
    }

    private static boolean isNonDecreasing() {
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void buildSegmentTree(int start, int end, int node) {
        if (start == end) {
            segTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildSegmentTree(start, mid, 2 * node);
            buildSegmentTree(mid + 1, end, 2 * node + 1);
            segTree[node] = Math.min(segTree[2 * node], segTree[2 * node + 1]);
        }
    }

    private static int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return segTree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(query(start, mid, 2 * node, left, right),
                query(mid + 1, end, 2 * node + 1, left, right));
    }

    private static void reverse(int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static int reverseSlopes() {
        int count = 0;
        int start = 0;
        while (start < N) {
            int end = start;
            while (end < N - 1 && arr[end] > arr[end + 1]) {
                end++;
            }
            if (end > start) {
                reverse(start, end);
                count++;
            }
            start = end + 1;
        }
        return count;
    }
}
