// https://www.acmicpc.net/problem/2608
// 로마 숫자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Character, Integer> romaNums = new HashMap<>();
    static Map<Integer, String> revertMap = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        // 로마 숫자 설정
        romaNums.put('I', 1);
        romaNums.put('V', 5);
        romaNums.put('X', 10);
        romaNums.put('L', 50);
        romaNums.put('C', 100);
        romaNums.put('D', 500);
        romaNums.put('M', 1000);

        // 변환 맵
        revertMap.put(1000, "M");
        revertMap.put(900, "CM");
        revertMap.put(500, "D");
        revertMap.put(400, "CD");
        revertMap.put(100, "C");
        revertMap.put(90, "XC");
        revertMap.put(50, "L");
        revertMap.put(40, "XL");
        revertMap.put(10, "X");
        revertMap.put(9, "IX");
        revertMap.put(5, "V");
        revertMap.put(4, "IV");
        revertMap.put(1, "I");

        // 두 로마숫자 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String romaNum1 = br.readLine();
        String romaNum2 = br.readLine();

        // 숫자 합 구하기
        int arabicSum = convertRomanToArabic(romaNum1) + convertRomanToArabic(romaNum2);

        // 아라비아 숫자 합과 로마 숫자로 변환된 값을 출력
        System.out.println(arabicSum);
        System.out.println(convertArabicToRoman(arabicSum));
    }

    // 로마숫자를 아라비아 숫자로 변환
    static int convertRomanToArabic(String romaNum) {

        int sum = 0;
        int prevNum = 0;

        for (int i = romaNum.length() - 1; i >= 0; i--) {
            int curNum = romaNums.get(romaNum.charAt(i));

            if (curNum < prevNum) sum -= curNum;
            else sum += curNum;

            prevNum = curNum;
        }

        return sum;
    }

    // 아라비아 숫자를 로마숫자로 변환
    static String convertArabicToRoman(int arabicNum) {
        StringBuilder romanNumeral = new StringBuilder();

        for (Integer key : revertMap.keySet()) {
            while (arabicNum >= key) {
                romanNumeral.append(revertMap.get(key));
                arabicNum -= key;
            }
        }

        return romanNumeral.toString();
    }
}
