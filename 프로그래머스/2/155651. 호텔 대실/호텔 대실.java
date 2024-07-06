import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 예약 시간을 분 단위로 변환
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = convertToMinutes(book_time[i][0]);
            times[i][1] = convertToMinutes(book_time[i][1]) + 10;
        }
        
        // 시작 시간을 기준으로 정렬
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        // 최소 객실 수 계산
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
        
        for (int[] time : times) {
            if (!endTimeQueue.isEmpty() && endTimeQueue.peek() <= time[0]) {
                endTimeQueue.poll();
            }
            endTimeQueue.add(time[1]);
        }
        
        return endTimeQueue.size();
    }
    
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}