class Solution {
    public int[] solution(int[] sequence, int k) {
        // 슬라이딩 윈도우
        int n = sequence.length;
        int start = 0, end = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        while (end < n) {
            sum += sequence[end];
            
            while (sum > k && start <= end) {
                sum -= sequence[start++];
            }
            
            if (sum == k) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    result[0] = start;
                    result[1] = end;
                }
            }
            
            end++;
        }
        
        return result;
    }
}