class Solution {
    public int solution(String s) {
        
        int answer = 0;
        int xCnt = 0;
        char x = '0';
        int notXCnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (xCnt == 0) {    // 첫 문자 저장
                x = s.charAt(i);
                xCnt++;
                notXCnt = 0;
                if (i == s.length() - 1) answer++;
            } else if (s.charAt(i) == x) {      // 첫 문자와 같은 문자
                xCnt++;
                if (i == s.length() - 1) answer++;
            } else {                            // 첫 문자와 다른 문자
                notXCnt++;
                if (xCnt == notXCnt) {          // 나온 횟수가 동일해지면
                    xCnt = 0;
                    notXCnt = 0;
                    answer++;
                } else if (i == s.length() - 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}