import java.io.*;

class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            // mode : 0
            if (mode == 0) {
                if (c == '1') mode = 1;
                else if (i % 2 == 0) answer.append(c);
            }
            // mode : 1
            else {
                if (c == '1') mode = 0;
                else if (i % 2 != 0) answer.append(c); 
            }
        }
        return answer.toString().equals("") ? "EMPTY" : answer.toString();
    }
}