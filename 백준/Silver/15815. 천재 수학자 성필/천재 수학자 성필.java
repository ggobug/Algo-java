// 천재 수학자 성필
// https://www.acmicpc.net/problem/15815

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// 후위 연산자

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        Set<Character> operationSet = new HashSet<>();
        operationSet.add('+');
        operationSet.add('-');
        operationSet.add('*');
        operationSet.add('/');

        for (char c : arr) {
            // 숫자면, 삽입
            if (!operationSet.contains(c)) {
                stack.push(Integer.parseInt(String.valueOf(c)));
            }
            // 연산자면 계산
            else {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(operation(c, a, b));
            }
        }
        System.out.println(stack.peek());
    }

    static int operation(char op, int a, int b) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            return a / b;
        }
    }
}
