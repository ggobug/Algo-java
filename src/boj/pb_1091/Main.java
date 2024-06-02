package boj.pb_1091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i % 3;

        st = new StringTokenizer(br.readLine());
        int[] P = new int[N];
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] S = new int[N];
        for (int i = 0; i < N; i++) S[i] = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        int ans = 0;
        while (true) {
            if (Arrays.equals(arr, P)) break;

            String arrStr = Arrays.toString(arr);
            if (!set.contains(arrStr)) set.add(arrStr);
            else { ans = -1; break; }
            ans++;
            suffle(S);
        }
        System.out.println(ans);

    }

    static void suffle(int[] brr) {
        int[] nArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) nArr[i] = arr[brr[i]];
        System.arraycopy(nArr, 0, arr, 0, arr.length);
//        for (int i = 0; i < arr.length; i++) arr[i] = nArr[i];

    }
}
