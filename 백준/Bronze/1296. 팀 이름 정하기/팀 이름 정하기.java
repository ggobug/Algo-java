import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String yeounDoo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        yeounDoo = br.readLine();
        int N = Integer.parseInt(br.readLine());    // 팀 이름 후보 수

        String[] candidates = new String[N];
        for (int i = 0; i < N; i++) {
            candidates[i] = br.readLine();
        }

        // 우승 확률 계산
        int[] winProbs = new int[N];
        for (int i = 0; i < N; i++) {
            winProbs[i] = calcProb(candidates[i]);
        }

        // 우승 확률이 가장 높은 팀 이름 찾기
        String bestName = findChampionship(candidates);
        System.out.println(bestName);
    }

    // 우승 확률 계산
    static int calcProb(String name) {
        int L = 0, O = 0, V = 0, E = 0;

        // 연두의 이름과 팀 이름에서 'L', 'O', 'V', 'E'의 개수 계산
        for (char ch : (yeounDoo + name).toCharArray()) {
            if (ch == 'L') L++;
            else if (ch == 'O') O++;
            else if (ch == 'V') V++;
            else if (ch == 'E') E++;
        }

        // 우승 확률 계산 공식
        int prob = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
        return prob;
    }

    // 우승 확률이 가장 높은 팀 찾기
    // 확률이 같으면 사전순으로 앞서는 팀이 우승 확률이 높다고 판정
    static String findChampionship(String[] candidates) {
        String bestName = "";
        int bestProb = -1;

        for (String candidate : candidates) {
            int prob = calcProb(candidate);
            // 더 높은 확률을 찾거나 확률이 같으면 사전순으로 앞서는 이름을 선택
            if (prob > bestProb || (prob == bestProb && candidate.compareTo(bestName) < 0)) {
                bestProb = prob;
                bestName = candidate;
            }
        }

        return bestName;
    }
}
