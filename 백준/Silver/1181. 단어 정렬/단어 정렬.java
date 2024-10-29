import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> words = new ArrayList<>(set);

        // 정렬 기준 설정 (길이순 정렬 후, 사전 순 정렬)
        words.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);  // 사전 순 정렬
            } else {
                return o1.length() - o2.length();  // 길이순 정렬
            }
        });

        for (String word : words) {
            System.out.println(word);
        }
    }
}
