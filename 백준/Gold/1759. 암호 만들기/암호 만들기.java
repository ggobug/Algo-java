import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] elements;
    static char[] selected;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        elements = new char[C];
        selected = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            elements[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(elements);

        generatePassword(0, 0, 0, 0);
    }

    static void generatePassword(int depth, int start, int vowelCount, int consonantCount) {
        if (depth == L) {
            if (vowelCount >= 1 && consonantCount >= 2) {
                System.out.println(new String(selected));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            selected[depth] = elements[i];
            if (isVowel(elements[i])) {
                generatePassword(depth + 1, i + 1, vowelCount + 1, consonantCount);
            } else {
                generatePassword(depth + 1, i + 1, vowelCount, consonantCount + 1);
            }
        }
    }
    static boolean isVowel(char ch) {
        for (char v : vowels) {
            if (ch == v) return true;
        }
        return false;
    }
}