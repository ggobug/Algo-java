// 좋은 수
// https://www.acmicpc.net/problem/1060

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L, S;
    static long[] arr;
    static List<long[]> goodNums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        L = Integer.parseInt(br.readLine());
        arr = new long[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            goodNums.add(new long[]{0, arr[i]});  // 집합 S의 요소는 구간 개수 0으로 추가
        }

        Arrays.sort(arr);  // 집합 S 정렬
        S = Integer.parseInt(br.readLine());  // 상위 S개의 좋은 수를 출력할 개수

        // 좋은 수 구하기
        findGoodNums(1, arr[0] - 1);  // 집합 S의 가장 작은 수 이전 구간
        for (int i = 0; i < L - 1; i++) {
            findGoodNums(arr[i] + 1, arr[i + 1] - 1);  // 집합 S 요소들 사이의 구간
        }

        // 정렬 및 출력
        goodNums.sort((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        printResult();
    }

    // 좋은 수 구간 찾기
    public static void findGoodNums(long left, long right) {
        long rangeCount = right - left;
        long inc = rangeCount - 1;
        int pushCount = 0;

        for (long i = 0; i <= (left + right) / 2; i++) {
            if (pushCount >= S || right - i < left + i) break;

            goodNums.add(new long[]{rangeCount, left + i});
            pushCount++;

            if (right - i != left + i) {
                goodNums.add(new long[]{rangeCount, right - i});
                pushCount++;
            }

            rangeCount += inc;
            inc -= 2;
        }
    }

    // 결과 출력 함수
    public static void printResult() {
        StringBuilder sb = new StringBuilder();
        int printedCount = 0;
        Set<Long> printed = new HashSet<>();

        for (int i = 0; i < Math.min(S, goodNums.size()); i++) {
            long value = goodNums.get(i)[1];
            if (!printed.contains(value)) {
                sb.append(value).append(" ");
                printed.add(value);
                printedCount++;
            }
        }

        long num = 1;
        while (printedCount < S) {
            if (!printed.contains(num)) {
                sb.append(num).append(" ");
                printed.add(num);
                printedCount++;
            }
            num++;
        }

        System.out.println(sb.toString().trim());
    }
}
