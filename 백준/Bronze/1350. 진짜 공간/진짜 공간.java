import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] files = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            files[i] = Long.parseLong(st.nextToken());
        }

        int clusterSize = Integer.parseInt(br.readLine());

        // 총 사용한 디스크 공간 계산
        long totalSpace = 0;
        for (long fileSize : files) {
            totalSpace += ((fileSize + clusterSize - 1) / clusterSize) * clusterSize;
        }

        System.out.println(totalSpace);
    }
}
