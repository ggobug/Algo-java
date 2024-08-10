import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> position = new HashMap();
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pre = position.getOrDefault(c, -1);
            if (pre != -1) {
                pre = i - pre;
            }
            answer[i] = pre;
            position.put(c, i);
        }
        
        return answer;
    }
}