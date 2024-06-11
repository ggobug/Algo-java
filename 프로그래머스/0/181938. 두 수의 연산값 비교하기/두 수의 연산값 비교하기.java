class Solution {
    public int solution(int a, int b) {
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        int op1 = Integer.parseInt(aStr.concat(bStr));
        int op2 = 2 * a * b;
        return Math.max(op1, op2);
    }
}