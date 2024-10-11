// https://www.acmicpc.net/problem/22252
// 정보 상인 호석

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;   // 쿼리 개수
    static Map<String, PriorityQueue<Integer>> gorillas;
    static long valueSum = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        gorillas = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            String gorillaName = st.nextToken();    // 고릴라 상인 이름
            if (query == 1) {   // 특정 고릴라 상인가 정보 획득

                if (!gorillas.containsKey(gorillaName)) {    // 키가 없는 상인인 경우
                    // 키 추가
                    gorillas.put(gorillaName, new PriorityQueue<>((a, b) -> b - a));    // 내림차순

                }

                // 정보 조회
                PriorityQueue<Integer> infos = gorillas.get(gorillaName);
                // 정보 추가
                int infoCnt = Integer.parseInt(st.nextToken());
                for (int j = 0; j < infoCnt; j++) {
                    infos.add(Integer.parseInt(st.nextToken()));
                }
            } else {            // 호석이가 정보 구매
                int buyCnt = Integer.parseInt(st.nextToken());
                // 정보 조회
                PriorityQueue<Integer> infos = gorillas.getOrDefault(gorillaName, new PriorityQueue<>((a, b) -> b - a));
                // 정보 구매
                int minCnt = Math.min(buyCnt, infos.size());
                for (int j = 0; j < minCnt; j++) {
                    valueSum += (long) infos.poll();
                }
            }
        }
        System.out.println(valueSum);

    }
}
