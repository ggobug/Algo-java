import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int mixCnt = 0;

        for (int num : scoville) {
            pq.add(num);
        }

        // 최저 스코빌지수가 K보다 작으면 섞기
        while (pq.peek() < K) {

            // 음식이 하나밖에 없는 경우 K 이상으로 만들 수 없음
            if (pq.size() == 1) {
                return -1;
            }

            int foodA = pq.poll();
            int foodB = pq.poll();
            int newFood = mixFood(foodA, foodB);
            mixCnt++;
            pq.add(newFood);
        }
        return mixCnt;
    }

    static int mixFood(int foodA, int foodB) {
        return foodA + foodB * 2;
    }
}