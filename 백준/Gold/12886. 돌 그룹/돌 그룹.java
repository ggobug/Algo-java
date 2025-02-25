import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int A = Integer.parseInt(parts[0]);
        int B = Integer.parseInt(parts[1]);
        int C = Integer.parseInt(parts[2]);

        System.out.println(canMakeEqual(A, B, C) ? 1 : 0);
    }

    /*
     * 돌을 같은 개수로 만들 수 있으면 : 1
     * 없으면 : 0
     */
    static boolean canMakeEqual(int a, int b, int c) {
        int sum = a + b + c;
        if (sum % 3 != 0) return false;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[1501][1501];

        queue.add(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], z = sum - x - y;

            if (x == y && y == z) return true;

            int[][] nextStates = {{x, y}, {x, z}, {y, z}};

            for (int[] state : nextStates) {
                int small = Math.min(state[0], state[1]);
                int large = Math.max(state[0], state[1]);

                if (small == large) continue;

                int nx = small + small;
                int ny = large - small;
                int nz = sum - nx - ny;

                int newA = Math.min(nx, ny);
                int newB = Math.max(nx, ny);

                if (!visited[newA][newB]) {
                    queue.add(new int[]{newA, newB});
                    visited[newA][newB] = true;
                }
            }
        }
        return false;
    }
}