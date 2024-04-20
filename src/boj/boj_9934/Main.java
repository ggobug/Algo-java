package boj.boj_9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 9934번 완전이진트리
// https://www.acmicpc.net/problem/9934
public class Main {

    static int K;
    static int[] arr;
    static List<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[(int) Math.pow(2, K) - 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            tree.add(new ArrayList<>());
        }

        insert(0, arr.length - 1, 0);

        for (int d = 0; d < K; d++) {
            for (int i = 0; i < tree.get(d).size(); i++) {
                sb.append(tree.get(d).get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void insert(int s, int e, int depth) {

        if (depth == K) {
            return;
        }

        int mid = (s + e) / 2;

        tree.get(depth).add(arr[mid]);

        insert(s, mid - 1, depth + 1);
        insert(mid + 1, e, depth + 1);
    }
}
