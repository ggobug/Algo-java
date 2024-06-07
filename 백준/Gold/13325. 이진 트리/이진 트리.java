import java.io.*;
import java.util.*;

public class Main {
    static int[] costs;
    static int k;
    static int totalCost = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, k + 1) - 1;  // 노드 수

        costs = new int[size + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= size; i++) costs[i] = Integer.parseInt(st.nextToken());

        // 최대 가중치 찾기
        dfs(1);
        System.out.println(totalCost);
    }

    static int dfs(int idx) {
        // 리프 노드인 경우
        if (idx * 2 >= costs.length) return 0;

        // 왼쪽 자식과 오른쪽 자식 dfs 호출
        int left = dfs(idx * 2) + costs[idx * 2];
        int right = dfs(idx * 2 + 1) + costs[idx * 2 + 1];

        // 가중치 차 가산
        totalCost += costs[idx * 2] + costs[idx * 2 + 1] + Math.abs(left - right);

        // 거리의 최대값을 반환
        return Math.max(left, right);
    }
}
