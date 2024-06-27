import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 3개의 수를 더했을 때 소수가 되는 경우의 개수 구하기
        
        int size = nums.length;
        
        // 1. 숫자 오름차순 정렬
        Arrays.sort(nums);
        
        // 2. 합의 최댓값 구하기
        int maxSum = nums[size -1] + nums[size - 2] + nums[size - 3];
        
        // 3. 소수 판별 후 결과 저장할 배열 생성
        boolean[] isPrime = new boolean[maxSum + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        // 4. 소수 판별
        for (int i = 2; i <= maxSum; i++) {
            // 소수라면 배수들 합성수로 처리
            if (isPrime[i]) {
                int j = i * 2;
                while (j <= maxSum) {
                    isPrime[j] = false;
                    j += i;
                }
            }
        }
        
        // 5. 3개 숫자 고르고 소수인지 체크
        int cntPrime = 0;
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime[sum]) cntPrime++;
                }
            }
        }
        return cntPrime;
    }
}