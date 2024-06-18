import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] student_1 = {1, 2, 3, 4, 5};
        int[] student_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = {
            markTest(student_1, answers), 
            markTest(student_2, answers), 
            markTest(student_3, answers)
            };
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        List<Integer> bestStudents = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                bestStudents.add(i + 1);
            }
        }

        return bestStudents.stream().mapToInt(i -> i).toArray();
    }
        
    public int getChoice(int[] student, int idx) {
        int length = student.length;
        int newIdx = idx % length;
        return student[newIdx];
    }
    
    public int markTest(int[] student, int[] answers) {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (getChoice(student, i) == answers[i]) {
                score++;
            }
        }
        return score;
    }
}