package boj.boj_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] nums1 = {2, 3, 5, 7};  // 처음 올 수 있는 수
    static int[] nums2 = {1, 3, 7, 9};  // 첫자리 외의 자리에 올 수 있는 수
    static int[] numbers = {1, 2, 3, 5, 7, 9};
    static HashMap<Integer, List<Integer>> primeSet = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        primeSet.put(1, new ArrayList<>()); // 1자리 신기한 소수 초기화
        for (int num : nums1) {
            if (checkPrime(num)) {
                primeSet.get(1).add(num);
            }
        }

        getPrimes(2);
        for (int p : primeSet.get(N)) {
            System.out.println(p);
        }
    }

    private static void getPrimes(int l) {

        // N자리 수까지 소수 구하면 종료
        if (l > N) {
            return;
        }

        // N-1자리 수의 소수에서 숫자 더하기
        List<Integer> prePrimeSet = primeSet.get(l - 1);
        List<Integer> curPrimeSet = new ArrayList<>();

        for (int num : prePrimeSet) {
            for (int i : numbers) {
                int newNum = num * 10 + i;
                if (checkPrime(newNum)) {
                    curPrimeSet.add(newNum);
                }
            }
        }

        primeSet.put(l, curPrimeSet);
        getPrimes(l+1);
    }

    public static boolean checkPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
