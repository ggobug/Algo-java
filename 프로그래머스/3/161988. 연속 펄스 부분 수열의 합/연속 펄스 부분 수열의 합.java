class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        // 펄스 수열 생성
        int[] pulse1 = new int[n];  // [1, -1, 1, -1, ...]
        int[] pulse2 = new int[n];  // [-1, 1, -1, 1, ...]
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                pulse1[i] = 1;
                pulse2[i] = -1;
            } else {
                pulse1[i] = -1;
                pulse2[i] = 1;
            }
        }
        
        // 카데인 알고리즘을 통해 최대 부분 합 계산
        long maxSum1 = getMaxPulseSum(sequence, pulse1);
        long maxSum2 = getMaxPulseSum(sequence, pulse2);
        
        return Math.max(maxSum1, maxSum2);
        
//         int size = sequence.length;
              
//         // 펄스 수열 만들기
//         for (int i = 0; i < size; i++) {
//             sequence[i] *= Math.pow(-1, i);
//         }
        
//         // 투포인터
//         long answer = Math.abs(sequence[0]);
//         int i = 0; int j = 1;
//         while (i <= j) {
//             if ()
//         }


        

//         return answer;
    }
    
        // 펄스 수열에 맞게 변환된 수열의 최대 부분합을 구하는 함수
    private long getMaxPulseSum(int[] sequence, int[] pulse) {
        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            // 펄스 수열과 곱한 값을 누적
            currentSum += sequence[i] * pulse[i];
            
            // 최대 값 갱신
            maxSum = Math.max(maxSum, currentSum);
            
            // 부분합이 음수가 되면 다시 시작
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return maxSum;
    }
}