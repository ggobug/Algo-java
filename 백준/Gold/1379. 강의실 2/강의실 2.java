import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n + 1]; // 강의실 배정 결과를 저장할 배열

        // 강의 시작 시간과 종료 시간을 기준으로 정렬
        PriorityQueue<int[]> lectures = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        // 강의 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new int[] {start, end, num});
        }

        // 강의실의 종료 시간과 강의실 번호를 저장하는 우선순위 큐
        PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        // 첫 번째 강의 배정
        int[] firstLecture = lectures.poll();
        rooms.add(new int[] {firstLecture[1], 1});
        result[firstLecture[2]] = 1;

        int roomCount = 1; // 강의실 번호

        // 나머지 강의 처리
        while (!lectures.isEmpty()) {
            int[] lecture = lectures.poll();
            if (rooms.peek()[0] <= lecture[0]) {
                int[] availableRoom = rooms.poll();
                result[lecture[2]] = availableRoom[1]; // 기존 강의실 사용
                rooms.add(new int[] {lecture[1], availableRoom[1]});
            } else {
                roomCount++;
                result[lecture[2]] = roomCount; // 새로운 강의실 배정
                rooms.add(new int[] {lecture[1], roomCount});
            }
        }

        // 최소 강의실 수 출력
        sb.append(roomCount).append("\n");

        // 각 강의에 배정된 강의실 번호 출력
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }
}
