// 트리
// https://www.acmicpc.net/problem/1068

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static int root;
    static int leafNodeCnt = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 노드의 개수
        tree = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x == -1) {
                root = i;
                continue;
            }
            tree[x].add(i);
        }

        st = new StringTokenizer(br.readLine());
        int deleteNode = Integer.parseInt(st.nextToken());

        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        removeNode(deleteNode);

        dfs(root);
        System.out.println(leafNodeCnt);

    }

    static void removeNode(int deleteNode) {
        for (int node : tree[deleteNode]) {
            removeNode(node);
        }
        for (int i = 0; i < N; i++) {
            tree[i].remove(Integer.valueOf(deleteNode));
        }
        tree[deleteNode].clear();
    }

    static void dfs(int node) {
        visited[node] = true;
        boolean isLeaf = true;

        for (int child : tree[node]) {
            if (!visited[child] && child != node) {
                isLeaf = false;
                dfs(child);
            }
        }

        if (isLeaf) {
            leafNodeCnt++;
        }
    }
}
