package boj_13901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 로봇 13901번
// https://www.acmicpc.net/problem/13901
// 새로운 클래스를 만들 때 equals, hashCode 오버라이드 하기!!

/*
* 1. 일직선 이동
* 2. 방문한 지역, 벽, 장애물 만나면 지정한 방향으로 움짐임
* 3. 다음 방향이 없다면 맨 처음 방향으로 돌아가서 1, 2번 반복
* 4. 움직일 수 없는 경우 정지
*/

public class Main {

    static int R;
    static int C;
    static int K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Set<Room> visited = new HashSet<>();
    static Room startRoom;
    static int[] directionOrder = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        // 장애물 위치 저장
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            Room room = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            visited.add(room);
        }

        // 로봇 시작 위치
        st = new StringTokenizer(br.readLine());
        startRoom = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        // 방향 순서 저장
        st = new StringTokenizer(br.readLine());
        for (int d = 0; d < 4; d++) {
            directionOrder[d] = Integer.parseInt(st.nextToken()) - 1;
        }

//        System.out.println(startRoom.x + " " + startRoom.y);

        visited.add(startRoom);
        move(startRoom, directionOrder[0], 0);
    }

    // 로봇 이동
    static void move(Room room, int d, int c) {

//        System.out.println("room = " + room.x + " " + room.y);
//        System.out.println("c = " + c + ", d = " + d);
//        System.out.println();

        for (int i = 0; i < 4; i++) {
            int nd = (d + i) % 4;
            int nx = room.x + dx[directionOrder[nd]];
            int ny = room.y + dy[directionOrder[nd]];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                continue;
            }

            Room nextRoom = new Room(nx, ny);
            if (visited.contains(nextRoom)) {
                continue;
            }

            visited.add(nextRoom);
            move(nextRoom, nd, c);
            return;
        }

        System.out.println(room.x + " " + room.y);

//        // 방향 4번 꺾으면 갈 곳이 없다는 판정. 정지
//        if (c >= 4) {
//            System.out.println(room.x + " " + room.y);
//            return;
//        }
//
//        // 이동
//        int nx = room.x + dx[directionOrder[d]];
//        int ny = room.y + dy[directionOrder[d]];
//
//        // 벽
//        if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
//            move(room, (d + 1) % 4, c + 1);
//            return;
//        }
//
//        Room nextRoom = new Room(nx, ny);
//
//        // 방문했거나 장애물
//        if (visited.contains(nextRoom)) {
//            move(room, (d + 1) % 4, c + 1);
//            return;
//        }
//
//        // 갈 수 있음
//        visited.add(nextRoom);
//        move(nextRoom, d, 0);
    }

    static class Room {
        int x;
        int y;

        public Room(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Room room = (Room) o;
            return x == room.x && y == room.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
