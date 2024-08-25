import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 포켓몬의 개수
        int M = Integer.parseInt(st.nextToken());   // 문제의 개수

        // 포켓몬 이름으로 번호 찾기
        Map<String, Integer> nameToNumber = new HashMap<>();
        // 포켓몬 번호로 이름 찾기
        String[] numberToName = new String[N + 1];

        for (int i = 1; i < N + 1; i++) {
            String pokemonName = br.readLine();
            nameToNumber.put(pokemonName, i);
            numberToName[i] = pokemonName;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) { // 숫자인 경우
                int number = Integer.parseInt(question);
                sb.append(numberToName[number]).append("\n");
            } else { // 문자인 경우
                sb.append(nameToNumber.get(question)).append("\n");
            }
        }

        System.out.println(sb);

    }
}
