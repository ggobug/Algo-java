class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;

        // 스티커가 1장인 경우
        if (n == 1) return sticker[0];

        // 첫 번째 스티커를 포함하는 경우와 포함하지 않는 경우를 각각 처리
        int answer = Math.max(maxSum(sticker, 0, n - 2), maxSum(sticker, 1, n - 1));
        return answer;
    }

    private int maxSum(int[] sticker, int s, int e) {
        int[] dp = new int[sticker.length];
        dp[s] = sticker[s];
        
        if (e - s >= 1) {
            dp[s + 1] = Math.max(sticker[s], sticker[s + 1]);
        }

        for (int i = s + 2; i <= e; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }

        return dp[e];
    }
}