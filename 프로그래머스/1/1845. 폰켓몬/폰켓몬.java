import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        int choice = N / 2;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int answer = Math.min(set.size(), choice);
        return answer;
    }
}