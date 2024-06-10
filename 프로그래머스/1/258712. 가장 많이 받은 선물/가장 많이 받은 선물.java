import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int size = friends.length;
        int[][] giftCnts = new int[size][size];

        // 선물 기록 정리
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String from = parts[0];
            String to = parts[1];
            int fromIdx = indexOf(friends, from);
            int toIdx = indexOf(friends, to);
            giftCnts[fromIdx][toIdx]++;
        }

        int[] receiveCnts = new int[size];

        // 선물 횟수 비교
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                int cntA = giftCnts[i][j];
                int cntB = giftCnts[j][i];

                // 선물 기록이 없거나 주고받은 수가 같다면
                if (cntA == cntB) {
                    int finalI = i;
                    int pointA = Arrays.stream(giftCnts[i]).sum() - IntStream.range(0, size)
                            .map(k -> giftCnts[k][finalI]).sum();
                    int finalJ = j;
                    int pointB = Arrays.stream(giftCnts[j]).sum() - IntStream.range(0, size)
                            .map(k -> giftCnts[k][finalJ]).sum();

                    if (pointA > pointB) receiveCnts[i]++;
                    else if (pointA < pointB) receiveCnts[j]++;
                }

                // 선물 기록이 있다면
                if (cntA != 0 || cntB != 0) {

                    if (cntA > cntB) receiveCnts[i]++;
                    else if (cntA < cntB) receiveCnts[j]++;
                }

            }
        }

        answer = Arrays.stream(receiveCnts).max().orElse(-1);
        return answer;
    }

    public static int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1; // 값이 없을 경우 -1 반환
    }
}