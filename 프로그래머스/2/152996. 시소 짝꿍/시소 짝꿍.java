import java.util.*;

class Solution {
    // 거리는 2, 3, 4
    
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Long> res = new HashMap<>();
        
        // 몸무게 오름차순 정렬
        Arrays.sort(weights);

        for (int weight : weights) {
            // 비율 맞는 사람 있는지 체크
            double w1 = weight * 1.0;
            double w2 = weight * 2.0 / 3.0;
            double w3 = weight * 1.0 / 2.0;
            double w4 = weight * 3.0 / 4.0;
            
            if (res.containsKey(w1)) answer += res.get(w1);
            if (res.containsKey(w2)) answer += res.get(w2);
            if (res.containsKey(w3)) answer += res.get(w3);
            if (res.containsKey(w4)) answer += res.get(w4);
            res.put(weight * 1.0, res.getOrDefault(weight * 1.0, 0L) + 1);
        }

        return answer;
    }
}