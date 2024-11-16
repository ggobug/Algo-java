// 색 막대
// https://www.acmicpc.net/problem/1696

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 같은 색깔끼리 닿도록 막대 일직선으로 놓기
        // 가능 불가능 판단하기

        /*
        * 접근법
        * 그래프 이론 + 오일러 경로
        *
        * -- 조건 --
        * 1. 홀수 차수를 가진 노드가 0개 또는 2개
        * 1-1. 2개인 경우 : 그 두 노드가 시작점, 끝점
        * 1-2. 0개인 경우 : 싸이클
        * 2. 색깔 : 노드
        * 3. 막대 : 간선
        * */

        Map<String, Integer> indegrees = new HashMap<>();   // 색깔(노드) 차수
        int size;   // 색깔 개수
        // 그래프 저장 (인접 리스트 형태로 연결된 색깔 기록)
        Map<String, Set<String>> graph = new HashMap<>();

        String input;
        while ((input = br.readLine()) != null) {
            String[] parts = input.split(" ");

            if (parts.length != 2) {
                break;
            }

            String start = parts[0];    // 막대 시작
            String end = parts[1];      // 막대 끝

            // 차수 증가
            indegrees.put(start, indegrees.getOrDefault(start, 0) + 1);
            indegrees.put(end, indegrees.getOrDefault(end, 0) + 1);

            // 간선 추가 (양방향 그래프)
            graph.putIfAbsent(start, new HashSet<>());
            graph.putIfAbsent(end, new HashSet<>());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 디버깅용 출력
//        System.out.println("차수 정보: " + indegrees);
//        System.out.println("그래프 정보: " + graph);

        // 한붓그리기 가능한지 체크
        // 1. 홀수 차수 개수 세기
        int oddNodeCnt = 0;
        for (int indegree : indegrees.values()) {
            if (indegree % 2 == 1) oddNodeCnt++;
        }

        // 2. 한붓그리기 조건 확인
        if (oddNodeCnt != 0 && oddNodeCnt != 2) {
            System.out.println("Impossible");
            return;
        }

        // 3. 연결 그래프인지 확인
        if (!isGraphConnected(graph, indegrees.keySet())) {
            System.out.println("Impossible");
            return;
        }

        // 4. 조건 만족 시 Possible 출력
        System.out.println("Possible");
    }

    // 그래프가 연결되어 있는지 확인하는 메서드
    static boolean isGraphConnected(Map<String, Set<String>> graph, Set<String> nodes) {
        if (nodes.isEmpty()) return true;

        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(nodes.iterator().next()); // 임의의 노드에서 시작

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!visited.add(current)) continue; // 이미 방문한 경우 무시
            if (graph.containsKey(current)) {
                stack.addAll(graph.get(current)); // 연결된 노드 방문
            }
        }

        // 방문한 노드의 수가 그래프에 있는 노드의 수와 같은지 확인
        return visited.size() == nodes.size();
    }

}
