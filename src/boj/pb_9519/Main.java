package boj.pb_9519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        String word = br.readLine();

        // 1 2 3 4 5 6 7
        // 1 3 5 7 6 4 2
        // 1 5 6 2 4 7 3
        // 1 6 4 3 7 2 5
        // 1 4 7 5 2 3 6
        // 1 7 2 6 3 5 4
        // 1 2 3 4 5 6 7

        Map<String, Integer> map = new HashMap<>();
        map.put(word, 0);


        String newWord = blink(word);
        int count = 1;

        while (!map.containsKey(newWord)) {
            map.put(newWord, count);
            newWord = blink(newWord);
            count++;
        }

        // X번 깜박였을 때의 단어
        int cnt = X % map.size();
        String result = getWord(map, cnt);
        System.out.println(result);
    }

    static String blink(String word) {
        StringBuilder newWord = new StringBuilder();

        // 짝수
        for (int i = 0; i < word.length(); i += 2) {
            newWord.append(word.charAt(i));
        }

        // 홀수
        int end = word.length() - 1;
        if (end % 2 == 0) {
            end--;
        }

        for (int i = end; i >= 0; i -= 2) {
            newWord.append(word.charAt(i));
        }

        return newWord.toString();
    }

    // 숫자로 단어 얻기
    static String getWord(Map<String, Integer> map, int value) {
        // 키값 쌍
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // 깜빡이는 횟수에 대응되는 단어
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
