import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        
        // 자물쇠를 확장하여 열쇠를 자물쇠 바깥에도 위치시킬 수 있도록 한다.
        int[][] newLock = new int[n + 2 * (m - 1)][n + 2 * (m - 1)];
        
        // 자물쇠를 확장된 배열의 중앙에 배치한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + m - 1][j + m - 1] = lock[i][j];
            }
        }
        
        // 열쇠를 4번 회전시키면서 이동시키는 모든 경우를 확인
        for (int r = 0; r < 4; r++) {
            key = rotateKey(key);  // 열쇠를 회전

            // 열쇠를 확장된 자물쇠의 모든 위치에 대해 적용
            for (int x = 0; x < n + m - 1; x++) {
                for (int y = 0; y < n + m - 1; y++) {
                    if (checkKeyFit(key, newLock, x, y, n)) {
                        return true;  // 열쇠가 맞는 경우 true 반환
                    }
                }
            }
        }
        
        return false;  // 모든 경우를 시도했으나 자물쇠를 열지 못한 경우
    }

    // 열쇠를 시계방향으로 90도 회전시키는 함수
    private int[][] rotateKey(int[][] key) {
        int m = key.length;
        int[][] rotatedKey = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotatedKey[j][m - 1 - i] = key[i][j];
            }
        }
        return rotatedKey;
    }

    // 자물쇠에 열쇠가 맞는지 확인하는 함수
    private boolean checkKeyFit(int[][] key, int[][] newLock, int startX, int startY, int n) {
        int m = key.length;
        
        // 임시 배열로 자물쇠 상태 복사
        int[][] tempLock = new int[newLock.length][newLock[0].length];
        for (int i = 0; i < newLock.length; i++) {
            tempLock[i] = newLock[i].clone();
        }

        // 열쇠를 이동된 위치에 맞추어 자물쇠에 적용
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tempLock[startX + i][startY + j] += key[i][j];
            }
        }

        // 자물쇠의 원래 크기(n x n)에 모든 홈(0)이 채워졌는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tempLock[i + m - 1][j + m - 1] != 1) {
                    return false;  // 홈이 채워지지 않거나 돌기가 겹친 경우
                }
            }
        }

        return true;  // 모든 홈이 열쇠로 채워진 경우
    }
}
