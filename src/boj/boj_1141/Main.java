package boj.boj_1141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);
        }

        Collections.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int ans = 0;

        for (int i = 0; i < words.size(); i++) {
            String curWord = words.get(i);
            boolean isContained = false;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).indexOf(curWord) == 0) {
                    isContained = true;
                    break;
                }
            }
            if (!isContained) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
