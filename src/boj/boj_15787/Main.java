package boj.boj_15787;

// 15787번 기차가 어둠을 헤치고 은하수를
// https://www.acmicpc.net/problem/15787

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 기차의 수
        int M = Integer.parseInt(st.nextToken());   // 명령의 수

        // 기차별 승객 정보 저장 (비트마스킹)
        long[] trainStates = new long[N];

        // 이미 지나간 기차 상태 저장 (Set)
        HashSet<Long> passedStates = new HashSet<>();

        int count = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken()) - 1;

            if (cmd == 1) {
                int seat = Integer.parseInt(st.nextToken()) - 1;
                // 자리에 배치
                trainStates[train] |= (1L << seat);
            } else if (cmd == 2) {
                int seat = Integer.parseInt(st.nextToken()) - 1;
                // 무조건 지우기
                trainStates[train] &= ~(1L << seat);
            } else if (cmd == 3) {
                // 모두 한 칸씩 뒤로 이동, 20번째 자리에 사람 있으면 하차
                if ((trainStates[train] & (1L << 19)) != 0) {
                    trainStates[train] &= ~(1L << 19);
                }
                trainStates[train] <<= 1;
            } else if (cmd == 4) {
                // 모두 한 칸씩 앞으로 이동, 1번재 자리 사람 있으면 하차
                if ((trainStates[train] & 1L) != 0) {
                    trainStates[train] &= ~1L;
                }
                trainStates[train] >>= 1;
            }
        }

        for (int i = 0; i < N; i++) {
            // 이미 지나간 상태라면 건너뛴다
            if (passedStates.contains(trainStates[i])) {
                continue;
            }

            passedStates.add(trainStates[i]);
            count++;
        }

        br.close();

        System.out.println(count);
    }
}
