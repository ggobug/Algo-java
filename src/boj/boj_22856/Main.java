package boj.boj_22856;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // N개의 이진 트리
    // 유사 중위 순회
    // 트리의 다양한 구현 방법 -> 직접 구현 후 비교해보기

    static int N;

    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static Node[] tree;
    static boolean[] visited;
    static int total;
    static int count;
    static List<Integer> orders;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        tree = new Node[N + 1];
        visited = new boolean[N + 1];
        orders = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 부모
            int b = Integer.parseInt(st.nextToken()); // 왼쪽 자식
            int c = Integer.parseInt(st.nextToken()); // 오른쪽 자식

            tree[a] = new Node(b, c);
        }

        // 중위 순회 순서 체크
        inOrder(1);

        // 유사 중위 순회
        similarInOrder(1);
    }

    static void similarInOrder(int now) {
        total++;

        if (!visited[now]) {
            visited[now] = true;
            count++;
        }

        if (tree[now].left != -1) {
            similarInOrder(tree[now].left);
            total++;
        }

        if (tree[now].right != -1) {
            similarInOrder(tree[now].right);
            total++;
        }

        if (count == N && now == orders.get(orders.size() - 1)) {
            System.out.println(total - 1);
        }
    }

    static void inOrder(int now) {


        if (tree[now].left != -1) {
            inOrder(tree[now].left);
        }

        orders.add(now);

        if (tree[now].right != -1) {
            inOrder(tree[now].right);
        }
    }

}
