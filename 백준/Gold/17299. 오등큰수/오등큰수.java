// https://www.acmicpc.net/problem/17299
// 오등큰수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        Map<Integer, Integer> counting = new HashMap<>();   // 나온 횟수 카운트

        // 수열 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = counting.getOrDefault(num, 0);
            counting.put(num, count + 1);
            seq[i] = num;
        }


        // 스택
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[N];  // 결과 저장할 배열

        // 오등큰수 찾기
        for (int i = N - 1; i >= 0; i--) {
            int curCount = counting.get(seq[i]);    // 현재 원소가 등장한 횟수

            // 스택에서 현재 원소보다 등장 횟수가 큰 원소 찾기
            while (!stack.isEmpty() && counting.get(stack.peek()) <= curCount) {
                stack.pop();
            }

            // 스택이 비어 있는 경우
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(seq[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
