import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 심사 시간 배열 오름차순 정렬
        Arrays.sort(times);
        
        long left = 1;  // 최소 시간
        long right = (long) times[times.length - 1] * (long) n;   // 최대 시간
        long answer = 0;
        
        while (left <= right) {
            long mid  = (left + right) / 2;
            
            // n명 이상 심사할 수 있는지 체크
            long count = 0;
            for (int time : times) {
                count += mid / time;
            }
            // 주어진 시간 내에 n명 이상 심사 가능한 경우
            if (count >= n) {   
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}