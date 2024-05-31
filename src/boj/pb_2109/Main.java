package boj.pb_2109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 대학 수

        int[][] lectures = new int[n][2];           // 강연 수
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        // 강연료 기준 내림차순
        Arrays.sort(lectures, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; // 날짜 오름차순
            } else {
                return b[0] - a[0]; // 강연료 내림차순
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int total = 0;      // 총 강연료
        int lastDay = 0;    // 마지막 강연한 날
        for (int[] lecture : lectures) {
            int price = lecture[0];
            int day = lecture[1];

            pq.offer(price);
            total += price;

            lastDay = Math.max(lastDay, day);   // 강연날 갱신

            if (pq.size() > lastDay) total -= pq.poll();    // 강연 못 가면 제외
        }
        System.out.println(total);
    }
}
