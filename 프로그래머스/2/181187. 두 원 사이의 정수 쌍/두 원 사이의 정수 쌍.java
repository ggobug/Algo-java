import java.util.*;

class Solution {
    
    public long solution(int r1, int r2) {
        // 전체 정수 좌표의 개수
        long total = 0L;
        
        // 1. 한 사분면에 있는 정수 좌표의 개수
        for (int x = 1; x < r2; x++) {
            long upperY = (long) Math.floor(Math.sqrt((long) r2 * r2 - (long) x * x));
            long lowerY = (long) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x));

            if (lowerY == 0) lowerY = 1;
            total += upperY - lowerY + 1;
        }

        // 2. 한 반직선에 있는 정수 좌표의 개수
        total += r2 - r1 + 1;
        total *= 4;
        
        return total;
    }

}