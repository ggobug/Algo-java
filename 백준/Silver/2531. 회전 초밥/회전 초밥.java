// 회전 초밥
// https://www.acmicpc.net/problem/2531

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, d, k, c;  // 접시의 수, 초밥의 가짓수, 연속해서 먹는 접시의 수, 쿠폰 번호
    static int[] plates, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        plates = new int[N];
        for (int i = 0; i < N; i++) plates[i] = Integer.parseInt(br.readLine());

        count = new int[d + 1];
        int uniqueCount = 0;
        int maxCount = 0;

        // 초기 설정
        for (int i = 0; i < k; i++) {
            if (count[plates[i]] == 0) uniqueCount++;
            count[plates[i]]++;
        }

        // 쿠폰 초밥 포함 여부 체크
        maxCount = uniqueCount + (count[c] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            count[plates[i-1]]--;
            if (count[plates[i-1]] == 0) uniqueCount--;
            if (count[plates[(i + k - 1) % N]] == 0) uniqueCount++;
            count[plates[(i + k - 1) % N]]++;

            maxCount = Math.max(maxCount, uniqueCount + (count[c] == 0 ? 1 : 0));
        }

        System.out.println(maxCount);
    }
}
