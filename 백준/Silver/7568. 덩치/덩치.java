import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] infos = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            infos[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            infos[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        // 완탐
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int rank = 1;
            int weight = infos[i][0];
            int height = infos[i][1];
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                
                // 자기보다 덩치 큰사람의 수 구하기
                if (weight < infos[j][0] && height < infos[j][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}
