class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int multiply = 1;
        int sumSquare = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            multiply *= num_list[i];
            sumSquare += num_list[i];
        }
        
        if (multiply < sumSquare * sumSquare) answer = 1;
        
        return answer;
    }
}