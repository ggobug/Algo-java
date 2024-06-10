class Solution {
    public int[] solution(int n, int k) {
        int size = n / k;
        
        int[] answer = new int[size];
        int num = k;
        for (int i = 0; i < size; i++) {
            answer[i] = (i + 1) * k;
        }
        return answer;
    }
}