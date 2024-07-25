import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;    // 재료의 개수, 갑옷을 만드는데 필요한 수
    static int[] materials; // N개 재료의 고유번호
    static boolean[] isUsed;
    static int armorCnt = 0;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        readIn();

        // 재료의 고유번호를 오름차순 정렬
        Arrays.sort(materials);

        // 사용된 배열 초기화
        isUsed = new boolean[materials[N - 1] + 1];

        // 앞에서 순회하면서 갑옷 만들기
        makeArmor();

        // 만들어진 갑옷 개수 출력
        System.out.println(armorCnt);
    }

    static void readIn() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        materials = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
    }

    // 갑옷을 만들기 위한 페어 찾기
    // 이분탐색
    static boolean findPair(int id, int sum) {
        int targetId = sum - id;
        int l = 0;
        int e = N - 1;
        int mid;
        while (l <= e) {
            mid = (l + e) / 2;
            // 페어 재료 찾으면
            if (materials[mid] == targetId) {
                return true;
            }
            // 중간값이 페어보다 작으면, 오른쪽 탐색
            else if (materials[mid] < targetId) {
                l = mid + 1;
            }
            // 중간값이 페어보다 크면, 왼쪽 탐색
            else {
                e = mid - 1;
            }
        }
        return false;
    }

    // 갑옷 만들기
    static void makeArmor() {
        for (int material : materials) {
            // 이미 사용된 재료가 아니라면
            if (!isUsed[material] && M != material * 2) {
                // 페어 재료가 있으면
                if (findPair(material, M)) {
                    armorCnt++; // 갑옷 만들기
                    isUsed[material] = true;
                    isUsed[M - material] = true;
                }
            }
        }
    }

}
