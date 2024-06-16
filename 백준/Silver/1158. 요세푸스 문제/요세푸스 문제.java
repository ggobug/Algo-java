import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) deque.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = -1;
        while (!deque.isEmpty()) {
            int cnt = 0;
            while (cnt < K) {
                deque.addLast(deque.pollFirst());
                cnt++;
            }
            int num = deque.pollLast();
            sb.append(num);
            if (!deque.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
