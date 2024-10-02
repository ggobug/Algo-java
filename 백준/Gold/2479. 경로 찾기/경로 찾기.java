// https://www.acmicpc.net/problem/2479
// 경로 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 아진 코드 수
        int K = Integer.parseInt(st.nextToken());   // 아진 코드 길이
        String[] codes = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            codes[i] = br.readLine();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());  // 시작 코드 번호
        int end = Integer.parseInt(st.nextToken());    // 끝 코드 번호

        // bfs
        int[] prev = new int[N + 1];
        Arrays.fill(prev, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        prev[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 끝에 도달하면 경로 출력
            if (current == end) {
                printPath(prev, start, end);
                return;
            }

            for (int i = 1; i <= N; i++) {
                if (prev[i] == -1 && calculDistance(codes[current], codes[i]) == 1) {
                    prev[i] = current;
                    queue.add(i);
                }
            }
        }

        // 경로를 찾지 못한 경우
        System.out.println(-1);
    }

    // 해밍 거리를 계산
    private static int calculDistance(String code1, String code2) {
        int distance = 0;
        for (int i = 0; i < code1.length(); i++) {
            if (code1.charAt(i) != code2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    // 경로 출력
    private static void printPath(int[] prev, int start, int end) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != 0; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        for (int node : path) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
