// 꿀따기
// https://www.acmicpc.net/problem/21758

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] box = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) box[i] = Integer.parseInt(st.nextToken());

        // 1. 벌통으로 일직선 이동
        // 2. 시작위치 제외 해당 값만큼 꿀 채밀
        // 벌은 두 마리, 벌통 하나
        // 채밀 가능한 최대 꿀의 양 구하기

        // 누적합 구하기 : O(N)
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) prefixSum[i] = prefixSum[i - 1] + box[i - 1];

        // 벌과 벌통의 상대적 위치로 접근하기

        int maxHoney = 0, firstBeeHoney, secondBeeHoney;
        // 1. 벌(0) - 벌통(i) - 벌(N-1)
        for (int i = 1; i < N - 1; i++) {
            firstBeeHoney = prefixSum[i + 1] - prefixSum[1];
            secondBeeHoney = prefixSum[N - 1] - prefixSum[i];
            int honey = firstBeeHoney + secondBeeHoney;
            maxHoney = Math.max(maxHoney, honey);
        }

        // 2. 벌(0) - 벌(i) - 벌통(N-1)
        for (int i = 1; i < N - 1; i++) {
            firstBeeHoney = prefixSum[N] - prefixSum[1] - box[i];
            secondBeeHoney = prefixSum[N] - prefixSum[i + 1];
            int honey = firstBeeHoney + secondBeeHoney;
            maxHoney = Math.max(maxHoney, honey);
        }

        // 3. 벌통(0) - 벌(i) - 벌(N-1)
        for (int i = 1; i < N - 1; i++) {
            firstBeeHoney = prefixSum[N -1] - box[i];
            secondBeeHoney = prefixSum[i];
            int honey = firstBeeHoney + secondBeeHoney;
            maxHoney = Math.max(maxHoney, honey);
        }

        System.out.println(maxHoney);
    }
}
