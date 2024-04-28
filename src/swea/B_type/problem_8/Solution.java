package swea.B_type.problem_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    // 최저 공통 조상(Lowest Common Ancestor)
    static int V, E; // 정점 수, 간선 수
    static int a, b;
    static int ans;
    static Node[] nodes;
    static ArrayList<Integer> ancestorA, ancestorB;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            nodes = new Node[V + 1];
            ancestorA = new ArrayList<>();
            ancestorB = new ArrayList<>();

            for (int i = 0; i < V + 1; i++) {
                nodes[i] = new Node();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int p, c;
                p = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                nodes[p].children.add(c);
                nodes[c].parents = p;
            }

            // a와 b의 조상 찾기
            traverse(a, ancestorA);
            traverse(b, ancestorB);

            for (int i = 0; i < V; i++) {
                if (!ancestorA.get(i).equals(ancestorB.get(i))) break;
                ans = ancestorA.get(i);
            }

            System.out.printf("#%d %d %d\n", tc, ans, dfs(ans));

        }

    }

    static int dfs(int idx) {  // idx 를 root로 갖는 subtree 의 크기를 계산하는 함수
        int res = 1;
        for (int child : nodes[idx].children) {
            res += dfs(child);
        }
        return res;
    }

    static void traverse(int idx, ArrayList<Integer> ancestor) {
        int parent = nodes[idx].parents;
        if (parent != 0) {  // 부모 노드가 존재한다면
            traverse(parent, ancestor);  // 조상을 더 찾으라고 재귀 호출 수행
        }
        ancestor.add(idx);
    }

    static class Node {
        List<Integer> children;
        int parents;

        Node() {
            this.children = new ArrayList<>();
            this.parents = 0;
        }
    }
}
