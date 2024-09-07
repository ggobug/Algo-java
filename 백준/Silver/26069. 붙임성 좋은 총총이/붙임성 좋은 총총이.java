import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 사람들이 만난 기록의 수
        Set<String> dancers = new HashSet<>();      // 무지개 댄스를 추고 있는 사람들을 저장할 집합
        dancers.add("ChongChong");
        
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            String A = parts[0];
            String B = parts[1];
            
            if (dancers.contains(A) || dancers.contains(B)) {
                dancers.add(A);
                dancers.add(B);
            }
        }
        System.out.println(dancers.size());
    }
}
