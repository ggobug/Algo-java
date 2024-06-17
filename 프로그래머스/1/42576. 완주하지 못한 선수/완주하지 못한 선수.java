import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // 완주하지 못한 선수 이름 찾기
        HashMap<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        for (String player : map.keySet()) {
            if (map.get(player) != 0) {
                return player;
            }
        }

        return null;
    }
}