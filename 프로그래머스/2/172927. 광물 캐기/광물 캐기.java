import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int maxTry = 0;
    int[] picks;
    String[] minerals;
    Map<String, Integer> materialMap = new HashMap<>();
    int[][] fatigueTable = {
        {1, 1, 1},     
        {5, 1, 1},     
        {25, 5, 1}     
    };
    
    public int solution(int[] picks, String[] minerals) {
        this.picks = picks;
        this.minerals = minerals;
        materialMap.put("diamond", 0);
        materialMap.put("iron", 1);
        materialMap.put("stone", 2);
        for (int i = 0; i < 3; i++) {
            maxTry += 5 * picks[i];
        }
        dfs(0, 0, 0);
        return answer;
    }
    
    private void dfs(int idx, int fatigue, int usedPick) {
        if (idx >= minerals.length || idx >= maxTry) { 
            answer = Math.min(answer, fatigue);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                int currentFatigue = 0;
                for (int j = 0; j < 5 && idx + j < minerals.length; j++) {
                    currentFatigue += fatigueTable[i][materialMap.get(minerals[idx + j])];
                }
                dfs(idx + 5, fatigue + currentFatigue, usedPick + 1);
                picks[i]++;
            }
        }
    }
}