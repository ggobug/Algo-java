package boj.problem_3758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int T, teamCnt, pbCnt, teamId, entries; // 팀 수, 문제 수, 팀 id, 엔트리 수
    static Team[] teams;

    static class Team {
        int id;
        int[] scores;
        int lastSubmitTime;
        int submitCount;
        int totalScore;

        public Team(int id, int[] scores, int lastSubmitTime, int submitCount, int totalScore) {
            this.id = id;
            this.scores = scores;
            this.lastSubmitTime = lastSubmitTime;
            this.submitCount = submitCount;
            this.totalScore = totalScore;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            teamCnt = Integer.parseInt(st.nextToken());
            pbCnt = Integer.parseInt(st.nextToken());
            teamId = Integer.parseInt(st.nextToken()) - 1;
            entries = Integer.parseInt(st.nextToken());

            // 팀 생성
            teams = new Team[teamCnt];
            for (int j = 0; j < teamCnt; j++) {
                teams[j] = new Team(j, new int[pbCnt], 0, 0, 0);
            }

            for (int j = 0; j < entries; j++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken()) - 1;
                int pbNum = Integer.parseInt(st.nextToken()) - 1;
                int getScore = Integer.parseInt(st.nextToken());

                teams[id].scores[pbNum] = Math.max(teams[id].scores[pbNum], getScore);
                teams[id].lastSubmitTime = j + 1;
                teams[id].submitCount++;
            }

            // 총 점수 계산
            for (int j = 0; j < teamCnt; j++) {
                teams[j].totalScore += Arrays.stream(teams[j].scores).sum();
            }

            // 정렬
            Arrays.sort(teams, new Comparator<Team>() {

                @Override
                public int compare(Team o1, Team o2) {

                    if (o1.totalScore == o2.totalScore) {
                        if (o1.submitCount == o2.submitCount) {
                            return o1.lastSubmitTime - o2.lastSubmitTime;
                        }
                        return o1.submitCount - o2.submitCount;
                    }
                    return o2.totalScore - o1.totalScore;
                }
            });

            for (int j = 0; j < teamCnt; j++) {
                if (teams[j].id == teamId) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}
