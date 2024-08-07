class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = (brown + 4) / 2;
        int product = brown + yellow;
        
        // 가로 길이
        for (int i = 3; i < sum - 2; i++) {
            int j = sum - i;
            if (i*j == product) {
                answer[0] = j;
                answer[1] = i;
                break;
            }
        }
        
        return answer;
    }
}