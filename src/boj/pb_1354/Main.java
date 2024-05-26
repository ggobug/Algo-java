package boj.pb_1354;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static long N, P, Q, X, Y;
    static Map<Long, Long> seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        // An 구하기
        // A[N] = A[N/P - X] + A[N/Q - Y]
        seq = new HashMap<>();
        seq.put(0L, 1L);

        System.out.println(getSeq(N));

    }

    static long getSeq(long x) {

        if (seq.containsKey(x)) {
            return seq.get(x);
        }

        long a = Math.max(x / P - X, 0L);
        long b = Math.max(x / Q - Y, 0L);

        long result = getSeq(a) + getSeq(b);

        seq.put(x, result);
        return result;
    }
}
