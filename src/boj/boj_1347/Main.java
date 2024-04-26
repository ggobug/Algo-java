package boj.boj_1347;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int direction = 0; // 남서북동 0 1 2 3;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int curRow, curCol, minRow, minCol, maxRow, maxCol = 0;
    static Set<String> visit = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        visit.add("0,0");

        st = new StringTokenizer(br.readLine());
        String maze = st.nextToken();
        for (int i = 0; i < maze.length(); i++) {
            commend(maze.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                String str;
                if (visit.contains(i + "," + j)) {
                    str = ".";
                } else {
                    str = "#";
                }
                sb.append(str);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void turnLeft() {
        direction += 3;
        direction %= 4;
    }

    static void turnRight() {
        direction++;
        direction %= 4;
    }

    static void commend(char c) {
        if (c == 'R') {
            turnRight();
        } else if (c == 'L') {
            turnLeft();
        } else {
            goFront();
        }
    }

    static void goFront() {
        curRow += dx[direction];
        curCol += dy[direction];

        minRow = Math.min(minRow, curRow);
        maxRow = Math.max(maxRow, curRow);
        minCol = Math.min(minCol, curCol);
        maxCol = Math.max(maxCol, curCol);

        visit.add(curRow + "," + curCol);
    }
}