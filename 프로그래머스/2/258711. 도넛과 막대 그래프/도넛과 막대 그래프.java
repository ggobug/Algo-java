import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int lastVertex = 0; // 마지막 정점

        for (int[] edge : edges) {
            lastVertex = Math.max(lastVertex, edge[0]);
            lastVertex = Math.max(lastVertex, edge[1]);
        }
        int[][] inOutCnts = new int[lastVertex + 1][2];

        // 초기 용량 설정은 성능의 최적화를 위함이다.
        List<List<Integer>> graph = new ArrayList<>(lastVertex + 1);

        for (int i = 0; i <= lastVertex; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inOutCnts[edge[1]][0]++;
            inOutCnts[edge[0]][1]++;
        }

        Set<Integer> exception = new HashSet<>();
        // 생성된 정점과 예외 찾기
        int generatedVertex = -1;
        for (int i = 0; i <= lastVertex; i++) {
            if (inOutCnts[i][0] == 0 && inOutCnts[i][1] >= 2) {
                generatedVertex = i;
            }
            if (inOutCnts[i][0] == 0 && inOutCnts[i][1] == 0) {
                exception.add(i);
            }
        }
        answer[0] = generatedVertex;


        // 총 그래프의 개수
        int totalGraphCnt = inOutCnts[generatedVertex][1];

        // 생성된 정점 제거
        for (int node : graph.get(generatedVertex)) {
            inOutCnts[node][0]--;
        }
        graph.get(generatedVertex).clear();
        inOutCnts[generatedVertex][1] = 0;


        // 그래프 종류 찾기
        // 도넛 그래프 : 모든 정점이 in 1, out 1
        // 막대 그래프 : in 0 or out 0인 정점 존재
        // 8자 그래프 : in 2 or out 2인 정점 존재
        for (int i = 1; i <= lastVertex; i++) {
            if (i == generatedVertex) continue;
            if (exception.contains(i)) continue;
            if (inOutCnts[i][1] == 0) answer[2]++;
            else if (inOutCnts[i][1] == 2) answer[3]++;
        }

        answer[1] = totalGraphCnt - answer[2] - answer[3];

        return answer;
    }
}