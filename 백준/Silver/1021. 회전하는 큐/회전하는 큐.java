import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 큐의 크기
        int M = Integer.parseInt(st.nextToken());   // 뽑으려는 수의 개수

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // 큐 초기화
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int minOpCnt = 0;
        // 숫자 뽑기
        for (int target : targets) {
            // 2번 연산 또는 3번 연산 중 연산 횟수가 적은 연산 수행

            int targetIdx = deque.indexOf(target);
            int halfIdx = deque.size() / 2;

            // 2번 연산 수행
            if (targetIdx <= halfIdx) {
                for (int i = 0; i < targetIdx; i++) {
                    deque.addLast(deque.removeFirst());
                    minOpCnt++;
                }
            }
            // 3번 연산 수행
            else {
                for (int i = 0; i < deque.size() - targetIdx; i++) {
                    deque.addFirst(deque.removeLast());
                    minOpCnt++;
                }
            }
            deque.removeFirst();
        }
        System.out.println(minOpCnt);
    }
}
