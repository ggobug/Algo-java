package boj.boj_16938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 문제 수
    static int L; // 난이도 합 하한
    static int R; // 난이도 합 상한
    static int X; // 난이도 차이 하한
    static List<Integer> problemList = new ArrayList<>(); // 문제 리스트
    static int count; // 출제 가능한 조합 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int difficulty = Integer.parseInt(st.nextToken());
            problemList.add(difficulty);
        }

        problemList.sort(Comparator.naturalOrder()); // 오름차순 정렬
        selectProblem(0, new ArrayList<>());

        System.out.println(count);
    }

    // 출제할 문제 선정
    static void selectProblem(int n, List<Integer> arr) {

        // 순회 끝
        if (n == N) {
            if (validation(arr)) {
                count++;
            }
            return;
        }

        // 선택
        arr.add(problemList.get(n));
        selectProblem(n+1, arr);
        arr.remove(arr.size()-1);
        selectProblem(n+1, arr);

    }

    // 유효성 검증
    static boolean validation(List<Integer> arr) {

        // 1. 난이도 합 유효성 검증
        Optional<Integer> optionalSum = arr.stream().reduce(Integer::sum);
        int sum = optionalSum.isPresent() ? optionalSum.get() : 0;        if (sum < L || sum > R) {
            return false;
        }

        // 2. 난이도 차 유효성 검증
        int gap = arr.get(arr.size()-1) - arr.get(0);
        if (gap < X) {
            return false;
        }

        return true;
    }
}
