import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Y F O : 2 3 4
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 플레이 신청 횟수
        char type = st.nextToken().charAt(0);               // 게임 종류

        Map<Character, Integer> playerNumber = new HashMap<>();
        playerNumber.put('Y', 2);
        playerNumber.put('F', 3);
        playerNumber.put('O', 4);

        Set<String> newPlayers = new HashSet<>();
        Set<String> players = new HashSet<>();

        int gameCount = 0;
        String player;
        for (int i = 0; i < N; i++) {
            player = br.readLine();
            if (players.contains(player)) continue;
            newPlayers.add(player);
            players.add(player);
            if (newPlayers.size() == playerNumber.get(type) - 1) {
                gameCount++;
                newPlayers.clear();
            }
        }

        System.out.println(gameCount);
    }
}
