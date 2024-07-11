import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
    // 선수들의 현재 순위를 저장할 Map
        Map<String, Integer> playerIndices = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndices.put(players[i], i);
        }

        for (String calling : callings) {
            int currentIndex = playerIndices.get(calling);
            if (currentIndex > 0) {
                // 현재 선수의 앞 선수와 자리 교환
                String previousPlayer = players[currentIndex - 1];
                players[currentIndex - 1] = calling;
                players[currentIndex] = previousPlayer;

                // 선수들의 순위 업데이트
                playerIndices.put(calling, currentIndex - 1);
                playerIndices.put(previousPlayer, currentIndex);
            }
        }

        return players;
    }
}