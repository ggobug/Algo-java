class Solution {
    public int solution(int[][] sizes) {
        
        int n = sizes.length;
        
        // 가로 > 세로로 설정
        int[] widths = new int[n];
        int[] heights = new int[n];
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int i = 0; i < n; i++) {
            int big = Math.max(sizes[i][0], sizes[i][1]);
            int small = Math.min(sizes[i][0], sizes[i][1]);
            maxWidth = Math.max(maxWidth, big);
            maxHeight = Math.max(maxHeight, small);
        }
        
        
        int answer = maxWidth * maxHeight;
        return answer;
    }
}