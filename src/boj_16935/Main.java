package boj_16935;

// 16935번 배열 돌리기 3
// https://www.acmicpc.net/problem/16935

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        // 2차원 배열 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 몇개가 나올지 모를땐 split() 메서드 사용
        String[] inputs = br.readLine().split(" ");

        // R번 연산 수행
        for (int r = 0; r < R; r++) {
            switch (inputs[r%(inputs.length)]) {
                case "1":
                    arr = operation1(arr);
                    break;
                case "2":
                    arr = operation2(arr);
                    break;
                case "3":
                    arr = operation3(arr);
                    break;
                case "4":
                    arr = operation4(arr);
                    break;
                case "5":
                    arr = operation5(arr);
                    break;
                case "6":
                    arr = operation6(arr);
                    break;
            }
        }

        // 배열 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 1번 연산
    public static int[][] operation1(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[arr.length - 1 - i][j];
            }
        }
        return newArr;
    }

    // 2번 연산 : 좌우 반전
    public static int[][] operation2(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[i][j] = arr[i][arr[i].length - 1 - j];
            }
        }
        return newArr;
    }

    // 3번 연산 : 오른쪽으로 90도 회전
    public static int[][] operation3(int[][] arr) {
        int[][] newArr = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[j][arr.length - 1 - i] = arr[i][j];
            }
        }
        return newArr;
    }

    // 4번 연산 : 왼쪽으로 90도 회전
    public static int[][] operation4(int[][] arr) {
        int[][] newArr = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[arr[0].length - 1 - j][i] = arr[i][j];
            }
        }
        return newArr;
    }

    // 5번 연산 : 위아래, 상하좌우 2등분씩, 총 4등분 후 각 그룹 시계 방향으로 바꾸기
    public static int[][] operation5(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];

        // 배열의 크기
        int rows = arr.length;
        int cols = arr[0].length;

        // 왼쪽 위 그룹을 오른쪽 위로 이동
        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < cols / 2; j++) {
                newArr[i][j + cols / 2] = arr[i][j];
            }
        }

        // 오른쪽 위 그룹을 오른쪽 아래로 이동
        for (int i = 0; i < rows / 2; i++) {
            for (int j = cols / 2; j < cols; j++) {
                newArr[i + rows / 2][j] = arr[i][j];
            }
        }

        // 오른쪽 아래 그룹을 왼쪽 아래로 이동
        for (int i = rows / 2; i < rows; i++) {
            for (int j = cols / 2; j < cols; j++) {
                newArr[i][j - cols / 2] = arr[i][j];
            }
        }

        // 왼쪽 아래 그룹을 왼쪽 위로 이동
        for (int i = rows / 2; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                newArr[i - rows / 2][j] = arr[i][j];
            }
        }

        return newArr;
    }

    // 6번 연산 : 5번 연산의 반대, 즉 반시계 방향으로 그룹 바꾸기
    public static int[][] operation6(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];

        // 배열의 크기
        int rows = arr.length;
        int cols = arr[0].length;

        // 오른쪽 위 그룹을 왼쪽 위로 이동
        for (int i = 0; i < rows / 2; i++) {
            for (int j = cols / 2; j < cols; j++) {
                newArr[i][j - cols / 2] = arr[i][j];
            }
        }

        // 오른쪽 아래 그룹을 오른쪽 위로 이동
        for (int i = rows / 2; i < rows; i++) {
            for (int j = cols / 2; j < cols; j++) {
                newArr[i - rows / 2][j] = arr[i][j];
            }
        }

        // 왼쪽 아래 그룹을 오른쪽 아래로 이동
        for (int i = rows / 2; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                newArr[i][j + cols / 2] = arr[i][j];
            }
        }

        // 왼쪽 위 그룹을 왼쪽 아래로 이동
        for (int i = 0; i < rows / 2; i++) {
            for (int j = 0; j < cols / 2; j++) {
                newArr[i + rows / 2][j] = arr[i][j];
            }
        }

        return newArr;
    }
}
