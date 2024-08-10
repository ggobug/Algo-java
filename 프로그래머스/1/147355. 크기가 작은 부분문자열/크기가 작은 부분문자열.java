class Solution {
    public int solution(String t, String p) {
        int length = p.length();
        long numP = Long.parseLong(p);
        int answer = 0;
        
        for (int i = 0; i < t.length() - length + 1; i++) {
            String substring = t.substring(i, i + length);
            long numT = Long.parseLong(substring);
            if (numT <= numP) answer++;
        }
        
        return answer;
    }
}