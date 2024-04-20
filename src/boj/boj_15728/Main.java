package boj.boj_15728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;   // 숫자 카드 수
    static int K;   // 견제 당할 카드 수
    public static void main(String[] args) throws IOException {
        //  N장의 공유 숫자카드, N장의 팀 숫자카드
        // 1. 적팀의 견제
        // 2. 공유 숫자카드 한 장, 팀 숫자카드 한 장 선택
        // 3. 두 카드의 곱을 점수로 획득
        // 4. 상대 팀도 반복 후 최종 점수가 높으면 승리

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Integer> sharedCards = new ArrayList<>();
        List<Integer> teamCards = new ArrayList<>();

        // 공유 카드 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sharedCards.add(Integer.parseInt(st.nextToken()));
        }

        // 팀 카드 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            teamCards.add(Integer.parseInt(st.nextToken()));
        }

        // K장 견제 완탐
        int maxScore;
        int idx;
        for (int i = 0; i < K; i++) {
            maxScore = Integer.MIN_VALUE;
            idx = -1;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < teamCards.size(); k++) {
                    if (maxScore < sharedCards.get(j) * teamCards.get(k)) {
                        maxScore = sharedCards.get(j) * teamCards.get(k);
                        idx = k;
                    }
                }
            }
            teamCards.remove(idx);
        }

        maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < teamCards.size(); j++) {
                maxScore = Math.max(sharedCards.get(i) * teamCards.get(j), maxScore);
            }
        }

        System.out.println(maxScore);
    }
}
