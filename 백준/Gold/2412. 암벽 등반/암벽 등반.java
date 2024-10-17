import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.y == other.y) {
                return this.x - other.x;
            }
            return this.y - other.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 홈 개수
        int T = Integer.parseInt(st.nextToken());   // 목표 y 좌표

        // 홈의 배열
        List<Point> grooves = new ArrayList<>();

        // n개의 x, y 좌표 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            grooves.add(new Point(x, y));
        }

        // 홈을 y 기준으로 정렬
        grooves.sort(Comparator.comparingInt(a -> a.y));

        int result = bfs(grooves, n, T);
        System.out.println(result);
    }

    static int bfs(List<Point> grooves, int n, int T) {
        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();

        // 시작점 (0, 0)
        queue.add(new Point(0, 0));

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                // 현재 좌표에서 이동 가능한 홈들 탐색
                Iterator<Point> it = grooves.iterator();
                while (it.hasNext()) {
                    Point next = it.next();

                    // |a - x| ≤ 2, |b - y| ≤ 2의 범위에 있는지 체크
                    if (Math.abs(current.x - next.x) <= 2 && Math.abs(current.y - next.y) <= 2) {
                        if (next.y == T) {  // 정상에 도달하면 이동 횟수 반환
                            return moves;
                        }
                        if (!visited.contains(next)) {  // 방문하지 않은 홈이면 탐색
                            visited.add(next);
                            queue.add(next);
                            it.remove();
                        }
                    } else if (next.y > current.y + 2) {
                        // 더 이상 유효한 범위 내의 홈이 없으므로 중단
                        break;
                    }
                }
            }
        }

        // 정상에 도달하지 못한 경우
        return -1;
    }
}
