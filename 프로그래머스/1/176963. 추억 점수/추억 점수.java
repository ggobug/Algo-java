import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // 그리움 점수 저장
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }        
        
        // 점수 계산
        int[] answer = new int[photo.length];
        for (int i= 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (!scoreMap.containsKey(photo[i][j])) continue;
                answer[i] += scoreMap.get(photo[i][j]);
            }
        }
        return answer;
    }
}