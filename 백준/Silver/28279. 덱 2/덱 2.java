import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] query = br.readLine().split(" ");
            switch (query[0]) {
                case "1":   // 덱 앞에 삽입
                    deque.addFirst(Integer.parseInt(query[1]));
                    break;
                case "2":   // 덱 뒤에 삽입
                    deque.addLast(Integer.parseInt(query[1]));
                    break;
                case "3":   // 맨 앞 정수 추출 후 출력
                    Integer front = deque.pollFirst();
                    sb.append(front != null ? front : -1).append("\n");
                    break;
                case "4":   // 맨 뒤 정수 추출 후 출력
                    Integer back = deque.pollLast();
                    sb.append(back != null ? back : -1).append("\n");
                    break;
                case "5":   // 덱 안 정수 개수 출력
                    sb.append(deque.size()).append("\n");
                    break;
                case "6":   // 비어있으면 1, 아니면 0 출력
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "7":   // 맨 앞 정수 출력
                    Integer peekFront = deque.peekFirst();
                    sb.append(peekFront != null ? peekFront : -1).append("\n");
                    break;
                case "8":   // 맨 뒤 정수 출력
                    Integer peekBack = deque.peekLast();
                    sb.append(peekBack != null ? peekBack : -1).append("\n");
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
