import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        row_begin -= 1;
        row_end -= 1;
        
        // 1. col 열 기준 오름차순 정렬, 동일하면 첫번째 열값 기준 내림차순 정렬
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] != b[col - 1]) {
                return a[col - 1] - b[col - 1]; // col 열 기준 오름차순
            } else {
                return b[0] - a[0]; // 첫 번째 열 기준 내림차순
            }
        });

        // 2. 해쉬값 구하기
        int answer = hashFunc(data, row_begin, row_end);
        return answer;
    }
    
    // 특정 열 나머지의 합
    public int sumTuple(int[][] data, int row) {
        int sum = 0;
        for (int i = 0; i < data[row].length; i++) {
            sum += data[row][i] % (row + 1);
        }
        return sum;
    }
    
    // 해쉬함수
    public int hashFunc(int[][] data, int row_begin, int row_end) {
        int x = 0;
        for (int i = row_begin; i <= row_end; i++) {
            x ^= sumTuple(data, i);
        }
        return x;
    }
}