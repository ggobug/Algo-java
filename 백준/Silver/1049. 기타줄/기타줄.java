import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 기타줄 수
        int M = Integer.parseInt(st.nextToken());   // 기타줄 브랜드 수


        int minPackage = Integer.MAX_VALUE; // 패키지 최소 가격
        int minSingle = Integer.MAX_VALUE;  // 낱개 최소 가격

        // 브랜드별 기타줄 가격 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int packagePrice = Integer.parseInt(st.nextToken());
            int singlePrice = Integer.parseInt(st.nextToken());
            minPackage = Math.min(minPackage, packagePrice);
            minSingle = Math.min(minSingle, singlePrice);
        }

        // 비용 계산
        int costPackageOnly = ((N + 5) / 6) * minPackage; // 패키지로만 구매
        int costMix = (N / 6) * minPackage + (N % 6) * minSingle; // 패키지 + 낱개 조합
        int costSingleOnly = N * minSingle; // 낱개로만 구매

        // 최솟값 출력
        int result = Math.min(costPackageOnly, Math.min(costMix, costSingleOnly));
        System.out.println(result);
    }
}
