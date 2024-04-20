package boj.boj_2230;

import java.awt.desktop.ScreenSleepEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 2_000_000_000;
        int i = 0;
        int j = 0;
        while (j < N && i < N) {
            int temp = arr[j] - arr[i];
            if (temp >= M) {
                i++;
                answer = Math.min(answer, temp);
            } else {
                j++;
            }
        }
        System.out.println(answer);
    }
}
