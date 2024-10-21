import java.util.*;

class Solution {
    public int solution(int storey) {
        // 자리수 별로 이동 선택
        int moveCount = 0;
        
        while (storey > 0) {
            int curNum = storey % 10;
            
            if (curNum > 5 || curNum == 5 && (storey / 10) % 10 >= 5) {
                moveCount += (10 - curNum);
                storey += 10;
            } else {
                moveCount += curNum;
            }
            
            storey /= 10;
        }
        
        return moveCount;
    }
}