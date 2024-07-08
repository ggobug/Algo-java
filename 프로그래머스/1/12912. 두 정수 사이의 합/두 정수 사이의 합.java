class Solution {
    public long solution(int a, int b) {
        long large = (long) Math.max(a, b);
        long small = (long) Math.min(a, b);
        
        long answer = (large + small) * (large - small + 1) / 2;
        return answer;
    }
}