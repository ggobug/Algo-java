import java.util.Arrays;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        // 모든 수의 합
        long totalSum = 0;
        for (int num : queue1) {
            totalSum += num;
        }
        long sum1 = totalSum;
        for (int num : queue2) {
            totalSum += num;
        }
        
        // 총합이 홀수인 경우 : 불가
        if (totalSum % 2 == 1) {
            return -1;
        }
        
        // 목표 합
        long goalSum = totalSum / 2;
        
        // pop, insert를 위한 배열 생성
        int size = queue1.length;
        int[] temp = new int[size * 2];
        
        // 배열 복사
        for (int i = 0; i < size * 2; i++) {
            if (i < size) {
                temp[i] = queue1[i];
            } else {
                temp[i] = queue2[i - size];
            }
        }
        
        int l = 0;
        int r = size;
        long curSum = Arrays.stream(queue1).asLongStream().sum();
        int count = 0;
        
        while (l < r && l < size * 2 && r < size * 2) {
            
            if (curSum == goalSum) {          // 현재합 == 목표합
                return count;
            } else if (curSum < goalSum) {    // 현재합 < 목표합
                curSum += temp[r++];
            } else {                          // 현재합 > 목표합
                curSum -= temp[l++];
            }
            count++;
        }
        
        return -1;
    }
}