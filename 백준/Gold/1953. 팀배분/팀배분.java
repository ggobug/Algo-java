// 팀배분
// https://www.acmicpc.net/problem/1953

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n;                       // 학생 수
    static ArrayList<Integer>[] dislike; // 싫어하는 사람들의 정보 리스트
    static int[] team;                  // 팀 정보: 1은 청팀, -1은 백팀, 0은 아직 배정되지 않음
    static ArrayList<Integer> blue;     // 청팀 명단
    static ArrayList<Integer> white;    // 백팀 명단

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dislike = new ArrayList[n + 1];
        team = new int[n + 1];
        blue = new ArrayList<>();
        white = new ArrayList<>();

        // 싫어하는 사람들 리스트 초기화
        for (int i = 1; i <= n; i++) {
            dislike[i] = new ArrayList<>();
        }

        // 입력 처리
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());  // 싫어하는 사람 수
            for (int j = 0; j < cnt; j++) {
                int hated = Integer.parseInt(st.nextToken());
                dislike[i].add(hated);
            }
        }

        // DFS로 팀 배정
        for (int i = 1; i <= n; i++) {
            if (team[i] == 0) {  // 아직 팀이 배정되지 않은 경우
                assignTeam(i, 1); // 청팀(1)부터 시작
            }
        }

        Collections.sort(blue);
        Collections.sort(white);

        StringBuilder sb = new StringBuilder();

        sb.append(blue.size()).append("\n");
        for (int person : blue) {
            sb.append(person).append(" ");
        }
        sb.append("\n");

        sb.append(white.size()).append("\n");
        for (int person : white) {
            sb.append(person).append(" ");
        }
        sb.append("\n");

        System.out.print(sb);
    }

    // 팀 배정
    static void assignTeam(int person, int t) {
        team[person] = t;  // 팀 배정
        if (t == 1) {
            blue.add(person); // 청팀에 추가
        } else {
            white.add(person); // 백팀에 추가
        }

        // 싫어하는 사람들을 반대팀에 배정
        for (int hated : dislike[person]) {
            if (team[hated] == 0) {
                assignTeam(hated, -t);  // 반대 팀 배정
            }
        }
    }
}
