import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] uniform = new int[n + 1];
        for (int num : reserve) {
            uniform[num] += 1;
        }
        for (int num : lost) {
            uniform[num] -= 1;
        }
        
        // 체육복을 입을 수 있는 학생 수
        for (int i = 1; i <= n; i++) {
            if (uniform[i] == -1) {
                if (uniform[i - 1] == 1) {  // 앞에서 빌리기
                    uniform[i] += 1;
                    uniform[i - 1] -= 1;
                } else if (i != n && uniform[i + 1] == 1) {  // 뒤에서 빌리기
                    uniform[i] += 1;
                    uniform[i + 1] -= 1;
                }        
            }
        }
        
        // uniform 배열에서 -1의 수를 세어서 n에서 뺀 값이 답
        int answer = 0;
        answer = n - (int) Arrays.stream(uniform).filter(x -> x == -1).count();
        return answer;
    }
}