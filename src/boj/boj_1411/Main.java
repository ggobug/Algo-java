package boj.boj_1411;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 단어의 개수

        Map<String, Integer> map = new HashMap<>();
        String newWord;
        int last;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            newWord = "";
            last = 0;
            Map<Character, Integer> charMap = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                // 이미 매핑된 문자일 경우
                if (charMap.containsKey(ch)) {
                    newWord = newWord.concat(charMap.get(ch).toString());
                } else {
                    ++last;
                    charMap.put(ch, last);
                    newWord = newWord.concat(String.valueOf(last));
                }
            }
            if (map.containsKey(newWord)) {
                map.put(newWord, map.get(newWord) + 1);
            } else {
                map.put(newWord, 1);
            }

        }

        int similarPairs = 0;
        for (int value : map.values()) {
            if (value >= 2) {
                similarPairs += value * (value - 1) / 2;
            }
        }
        System.out.println(similarPairs);


    }
}
