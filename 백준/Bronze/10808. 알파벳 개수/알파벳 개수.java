import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Map<Character, Integer> countMap = new HashMap<>();
        countMap.put('a', 0);
        countMap.put('b', 0);
        countMap.put('c', 0);
        countMap.put('d', 0);
        countMap.put('e', 0);
        countMap.put('f', 0);
        countMap.put('g', 0);
        countMap.put('h', 0);
        countMap.put('i', 0);
        countMap.put('j', 0);
        countMap.put('k', 0);
        countMap.put('l', 0);
        countMap.put('m', 0);
        countMap.put('n', 0);
        countMap.put('o', 0);
        countMap.put('p', 0);
        countMap.put('q', 0);
        countMap.put('r', 0);
        countMap.put('s', 0);
        countMap.put('t', 0);
        countMap.put('u', 0);
        countMap.put('v', 0);
        countMap.put('w', 0);
        countMap.put('x', 0);
        countMap.put('y', 0);
        countMap.put('z', 0);

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            countMap.put(c, countMap.get(c) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer value : countMap.values()) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
    }
}
