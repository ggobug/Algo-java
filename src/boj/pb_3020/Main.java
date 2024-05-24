package boj.pb_3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동굴의 길이
        int H = Integer.parseInt(st.nextToken()); // 동굴의 높이
        int size = N / 2;

        // 파괴해야 하는 장애물의 최솟값과 그 구간의 수
        int[] top = new int[size];
        int[] bottom = new int[size];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (i % 2 == 0) {
                bottom[i / 2] = Integer.parseInt(st.nextToken());
            } else {
                top[i / 2] = Integer.parseInt(st.nextToken());
            }
        }

        // 이분탐색을 위해 정렬
        Arrays.sort(top);
        Arrays.sort(bottom);

        // target이 bottom에서 위치한 인덱스의 size - idx 만큼 파괴
        // H-target이 top에서 위치한 인덱스의 size - idx 만큼 파괴
        // 두 합의 최소값을 가지는 target 찾기
        // 이분탐색으로 위치 찾기

        int ans = Integer.MAX_VALUE;    // 최소로 파괴할 장애물 수
        int height = 0;               // 최소 구간의 수

        // 적절한 높이 찾기
        for (int target = 1; target <= H; target++) {
            int bottomCnt = size - binarySearch(bottom, target);
            int topCnt = size - binarySearch(top, H - target + 1);

            int totalCnt = bottomCnt + topCnt;

            if (totalCnt < ans) {
                ans = totalCnt;
                height = 1;
            } else if (totalCnt == ans) {
                height++;
            }
        }

        System.out.println(ans + " " + height);
    }

    // 이분탐색
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
