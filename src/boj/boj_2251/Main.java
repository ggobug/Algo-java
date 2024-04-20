package boj.boj_2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<String> visited;
    static ArrayList<Integer> answerList;
    static int[] container;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        container = new int[]{A, B, C};

        answerList = new ArrayList<>();
        answerList.add(C);
        visited = new HashSet<>();
        visited.add("0 0 " + C);

        bfs();

        Collections.sort(answerList);
        for (Integer i : answerList) {
            System.out.print(i + " ");
        }
    }

    static void bfs() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("0 0 " + container[2]);

        while (!queue.isEmpty()) {
            String[] current = queue.poll().split(" ");
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(current[i]);
            }

            // A 물통이 비어있을 때, C 물통의 물의 양을 저장
            if (arr[0] == 0 && !answerList.contains(arr[2])) {
                answerList.add(arr[2]);
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to || arr[from] == 0 || arr[to] == container[to]) continue;

                    int[] next = arr.clone();
                    int amount = Math.min(arr[from], container[to] - arr[to]);
                    next[from] -= amount;
                    next[to] += amount;
                    String nextState = next[0] + " " + next[1] + " " + next[2];
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }
        }
    }
}
