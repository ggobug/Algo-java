package boj.pb_8911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //                 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String command = br.readLine();

            int d = 0; // 상
            int minX = 0, maxX = 0, minY = 0, maxY = 0;
            int curX = 0, curY = 0;

            for (int i = 0; i < command.length(); i++) {
                char cmd = command.charAt(i);
                switch (cmd) {
                    case 'F':   // 전진
                        curX += dx[d];
                        curY += dy[d];
                        break;
                    case 'B':   // 후진
                        curX -= dx[d];
                        curY -= dy[d];
                        break;
                    case 'R':   // 오른쪽으로 90도 회전
                        d = (d + 1) % 4;
                        break;
                    case 'L':   // 왼쪽으로 90도 회전
                        d = (d + 3) % 4;
                        break;
                    default:
                        break;
                }
                minX = Math.min(minX, curX);
                maxX = Math.max(maxX, curX);
                minY = Math.min(minY, curY);
                maxY = Math.max(maxY, curY);
            }

            int area = (maxX - minX) * (maxY - minY);
            System.out.println(area);
        }

    }
}
