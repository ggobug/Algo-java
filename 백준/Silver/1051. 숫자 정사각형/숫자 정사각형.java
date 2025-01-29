import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);

        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        int maxSize = 1;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                for (int L = 1; x + L < N && y + L < M; L++) { // 변의 길이를 늘려가며 검사
                    if (graph[x][y] == graph[x + L][y] &&
                            graph[x][y] == graph[x][y + L] &&
                            graph[x][y] == graph[x + L][y + L]) {
                        maxSize = Math.max(maxSize, (L + 1) * (L + 1));
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}
