import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Set<String>> caseMap = new HashMap<>();
        for (String[] cloth : clothes) {
            if (!caseMap.containsKey(cloth[1])) {
                Set<String> newSet = new HashSet<>();
                caseMap.put(cloth[1], newSet);
            }
            caseMap.get(cloth[1]).add(cloth[0]);
        }
        // 모든 옷 종류의 개수 곱하기 - 1
        int answer = 1;
        for (Set<String> value : caseMap.values()) {
            answer *= (value.size() + 1);
        }
        return answer - 1;
    }
}