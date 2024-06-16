import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numberList = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberList[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numberList, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder answer = new StringBuilder();
        for (String str : numberList) {
            answer.append(str);
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}