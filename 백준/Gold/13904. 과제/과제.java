// 과제
// https://www.acmicpc.net/problem/13904

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Homework> homeworks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());   // 남은 일수
            int w = Integer.parseInt(st.nextToken());   // 점수
            homeworks.add(new Homework(d, w));
        }

        // 점수 기준 내림차순 정렬
        homeworks.sort((a, b) -> b.score - a.score);

        boolean[] days = new boolean[1001];
        int maxScore = 0;

        for (Homework hw : homeworks) {
            for (int j = hw.day; j > 0; j--) {
                if (!days[j]) {
                    days[j] = true;
                    maxScore += hw.score;
                    break;
                }
            }
        }

        System.out.println(maxScore);
    }

    static class Homework {
        int day;
        int score;

        Homework(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
}
