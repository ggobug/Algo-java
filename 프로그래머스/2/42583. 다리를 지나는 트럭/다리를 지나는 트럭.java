import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 큐 초기화
        Queue<Integer> onBridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            onBridge.add(0);
        }
        
        int time = 0;
        int idx = 0;
        int totalWeight = 0;
        while (idx < truck_weights.length) {
            totalWeight -= onBridge.poll();
            time++;
            
            // 다리에 트럭 추가할 수 있으면
            if (totalWeight + truck_weights[idx] <= weight) {
                onBridge.add(truck_weights[idx]);
                totalWeight += truck_weights[idx++];
            }
            // 못 가면
            else {
                onBridge.add(0);
            }
        }
        time += bridge_length;
        return time;
    }
}