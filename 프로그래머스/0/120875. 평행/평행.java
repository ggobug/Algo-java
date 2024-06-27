class Solution {
    public int solution(int[][] dots) {
        
        // 4개 좌표를 두 개씩 이어주는 케이스 : 3 가지
        // 기울기가 같으면 1, 다르면 0
        for (int i = 0; i < 3; i++) {
            double slopeA = (double) (dots[0][1] - dots[i + 1][1]) / (dots[0][0] - dots[i + 1][0]);
            double slopeB = (double) (dots[(i+1)%3+1][1] - dots[(i+2)%3+1][1]) / (dots[(i+1)%3+1][0] - dots[(i+2)%3+1][0]);
            if (slopeA == slopeB) return 1;
        }
        return 0;
    }
}