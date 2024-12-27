// 나이순 정렬
// https://www.acmicpc.net/problem/10814

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[][] members = new String[N][2]; // 회원 정보 저장 (나이, 이름)

        // 회원 정보 입력 받기
        for (int i = 0; i < N; i++) {
            members[i] = br.readLine().split(" ");
        }

        // 정렬: 나이를 기준으로 오름차순, 나이가 같으면 입력 순서 유지
        Arrays.sort(members, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (String[] member : members) {
            sb.append(member[0]).append(" ").append(member[1]).append("\n");
        }
        System.out.print(sb);
    }
}
