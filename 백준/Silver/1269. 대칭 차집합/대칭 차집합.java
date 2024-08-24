import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 공집합이 아닌 두 집합
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        // 두 집합의 대칭 차집합의 원소의 개수를 출력

        // A - B
        Set<Integer> C = new HashSet<>(A);
        C.removeAll(B);

        // B - A
        Set<Integer> D = new HashSet<>(B);
        D.removeAll(A);

        // 대칭 차집합
        C.addAll(D);

        // 개수 출력
        System.out.println(C.size());
    }
}
