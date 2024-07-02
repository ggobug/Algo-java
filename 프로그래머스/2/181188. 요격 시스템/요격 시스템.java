import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        // targets 종료지점 기준 오름차순 정렬하기
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 0;
        double lastIntercept = -1;

        for (int[] target : targets) {
            if (lastIntercept < target[0]) {
                lastIntercept = target[1] - 0.5;
                answer++;
            }
        }

        return answer;
    }
}