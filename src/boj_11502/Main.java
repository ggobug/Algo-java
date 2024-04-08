package boj_11502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 5보다 큰 임의의 홀수는 정확히 세 개의 소수들의 합으로 나타낼 수 있다.
        // 물론 하나의 소수를 여러 번 더할 수 있다.

        boolean prime[] = new boolean[1001];
        List<Integer> primeList = new ArrayList<>();

        prime[0] = prime[1] = true;

        // 소수 판별
        for (int i = 2; i*i <= 1000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    prime[j] = true;
                }
            }
        }

        // 소수만 리스트에 삽입
        for (int i = 1; i <= 1000; i++) {
            if (!prime[i]) {
                primeList.add(i);
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean possible = false;
            for (int p : primeList) {
                if (p >= N - 3) {
                    break;
                }
                for (int q : primeList) {
                    if (p + q > N - 2) {
                        break;
                    }
                    for (int r : primeList) {
                        if (p + q + r > N) {
                            break;
                        }
                        if (p + q + r == N) {
                            System.out.println(p + " " + q + " " + r);
                            possible = true;
                            break;
                        }
                    }
                    if (possible) {
                        break;
                    }
                }
                if (possible) {
                    break;
                }
            }
            if (!possible) {
                // 아무 것도 찾지 못 하면
                System.out.println(0);
            }
        }
    }
}
