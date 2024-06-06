import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] dices = new int[n][6];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // A B C D E F -> 0 1 2 3 4 5 / A-F B-D C-E / 0-5 1-3 2-4
            for (int j = 0; j < 6; j++) dices[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] pairs = {5, 3, 4, 1, 2, 0};

        // 한 옆면의 숫자의 합의 최댓값 구하기
        int[] sum = new int[6];

        // 1. 첫 주사위 놓기
        // i : 윗면 인덱스
        int topNum, bottomNum, topIdx;
        for (int i = 0; i < 6; i++) {
            // 윗면 바닥면을 제외한 수의 최댓값

            topNum = dices[0][pairs[i]];
            bottomNum = dices[0][i];

            sum[i] = findMaxNum(topNum, bottomNum);

            // 윗면의 숫자와 일치하는 주사위 붙이기
            for (int j = 1; j < n; j++) {
                bottomNum = topNum;
                topIdx = pairs[findIndex(dices[j], bottomNum)];
                topNum = dices[j][topIdx];
                sum[i] += findMaxNum(topNum, bottomNum);
            }
        }
        System.out.println(Arrays.stream(sum).max().getAsInt());
    }

    static int findMaxNum(int topNum, int bottomNum) {
        int maxNum = 6;
        boolean hasSix = false, hasFive = false;
        if (topNum == 6 || bottomNum == 6) hasSix = true;
        if (topNum == 5 || bottomNum == 5) hasFive = true;

        if (hasSix) {
            if (hasFive) maxNum = 4;
            else maxNum = 5;
        }
        return maxNum;
    }

    static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
