//블랙잭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 카드 3장 합 M 이하, 최대로 만들기

        int N = Integer.parseInt(st.nextToken());    // 카드의 수
        int M = Integer.parseInt(st.nextToken());   // 상한선

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;

        //2.정렬, 이진탐색
        Arrays.sort(cards);

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int remain = M - (cards[i] + cards[j]);
                int left = j + 1, right = N - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int sum = cards[i] + cards[j] + cards[mid];

                    if (sum == M) {
                        max = M;
                        break;
                    }
                    if (sum < M) {
                        max = Math.max(max, sum);
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        
        System.out.println(max);


    }
}
