// 팰린드롬?
// https://www.acmicpc.net/problem/10942

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());   // 자연수 개수
        int[] nums = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];

        // 칠판에 적힌 N개의 수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());    // 질문 수

        // 팰린드롬 체크
        // 길이 : 1 (홀수)
        for (int i = 0; i < n; i++) isPalindrome[i][i] = true;
        // 길이 : 2 (짝수)
        for (int i = 0; i < n - 1; i++) {
            // 두 수가 같으면 팰린드롬
            if (nums[i] == nums[i + 1]) isPalindrome[i][i + 1] = true;
        }
        // 길이 3이상
        for (int l = 3; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                // 처음과 끝이 같고, 그 안의 수가 팰린드롬이면 팰린드롬이
                if (nums[i] == nums[i + l - 1] && isPalindrome[i + 1][i + l - 2]) isPalindrome[i][i + l - 1] = true;
            }
        }

        int s, e;   // 시작, 끝 인덱스
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()) - 1;
            e = Integer.parseInt(st.nextToken()) - 1;
            if (isPalindrome[s][e]) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
