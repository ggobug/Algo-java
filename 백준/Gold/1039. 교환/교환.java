// 교환
// https://www.acmicpc.net/problem/1039

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);

        int result = bfs(N, K);
        System.out.println(result);
    }

    // 자리수 바꾸는 연산 : i와 j 자리수의 숫자 바꾸기
    static int swapDigit(int num, int i, int j) {
        char[] digits = String.valueOf(num).toCharArray();

        // 자리 교환
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // 0으로 시작하지 않도록 체크
        if (digits[0] == '0') return -1;

        return Integer.parseInt(new String(digits));
    }

    // 너비우선탐색 : 만들 수 있는 가장 큰 수 반환
    static int bfs(int N, int K) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // 초기 상태 추가
        queue.offer(new int[]{N, 0});
        visited.add(N + "," + 0);

        int max = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];
            int depth = current[1];

            if (depth == K) {
                max = Math.max(max, num);
                continue;
            }

            char[] digits = String.valueOf(num).toCharArray();
            int length = digits.length;

            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    int swapped = swapDigit(num, i, j);

                    if (swapped != -1) {
                        String state = swapped + "," + (depth + 1);
                        if (!visited.contains(state)) {
                            queue.offer(new int[]{swapped, depth + 1});
                            visited.add(state);
                        }
                    }
                }
            }
        }

        return max;
    }
}
