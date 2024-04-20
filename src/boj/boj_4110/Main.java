package boj.boj_4110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 당구대 쿠션 위치
    private static int topY;
    private static int bottomY;
    private static int leftX;
    private static int rightX;

    private static int[] whiteBall = new int[2];
    private static int[] redBall = new int[2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {

            st = new StringTokenizer(br.readLine());

            // L W CX CY TX TY N
            int L = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int CX = Integer.parseInt(st.nextToken());
            int CY = Integer.parseInt(st.nextToken());
            int TX = Integer.parseInt(st.nextToken());
            int TY = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if (L == 0 && W == 0 && CX == 0 && CY == 0 && TX == 0 && TY == 0 && N == 0) {
                break;
            }

            double distance = solve(L, W, CX, CY, TX, TY, N);

            System.out.printf("%.3f\n");


        }



    }

    // 거리 계산
    private static double solve(int l, int w, int cx, int cy, int tx, int ty, int n) {

        topY = w; bottomY = 0; leftX = 0; rightX = l;
        whiteBall[0] = cx; whiteBall[1] = cy;
        redBall[0] = tx; redBall[1] = ty;



        return 0;
    }

    // TOP 쿠션


    // BOTTOM 쿠션


    // LEFT 쿠션


    // RIGHT 쿠션


}
