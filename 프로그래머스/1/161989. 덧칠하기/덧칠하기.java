class Solution {    
    public int solution(int n, int m, int[] section) {
        int l = section.length;
        int i = 0;
        int next = -1;
        int answer = 0;
        
        while (i < l) {
            if (section[i] < next) {
                i++;
                continue;
            }
            next = section[i] + m;
            i++;
            answer++;
        }
        return answer;
    }
}