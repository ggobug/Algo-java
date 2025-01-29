import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 가운데를 말해요
// https://www.acmicpc.net/problem/1655
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 정수의 개수

        PriorityQueue<Integer> asc = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> desc = new PriorityQueue<>((a, b) -> b - a); // 내림차순
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());    // 백준이 말한 정수

            if (asc.size() == desc.size()) {
                desc.add(x);
            } else {
                asc.add(x);
            }

            if (asc.isEmpty()) {
                sb.append(desc.peek()).append("\n");
            } else {
                if (desc.peek() > asc.peek()) {
                    desc.add(asc.poll());
                    asc.add(desc.poll());
                }
                sb.append(desc.peek()).append("\n");
            }
        }
        System.out.println(sb);

    }
}
