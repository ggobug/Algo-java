import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int callCnt;

    static int recursion(int l, int r, char[] word) {
        callCnt++;
        if (l >= r) return 1;
        else if (word[l] != word[r]) return 0;
        else return recursion(l + 1, r - 1, word);
    }

    static int isPalindrom(char[] word) {
        return recursion(0, word.length - 1, word);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            char[] input = br.readLine().toCharArray();
            callCnt = 0;
            sb.append(isPalindrom(input))
                    .append(" ").append(callCnt).append("\n");
        }
        System.out.println(sb);
    }
}
