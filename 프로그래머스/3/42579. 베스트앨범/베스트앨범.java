import java.util.*;

class Solution {

    // 곡 정보를 담는 클래스
    static class Song {
        int index;
        int playCount;

        public Song(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        int n = genres.length;

        // 장르별 총 재생 횟수
        Map<String, Integer> genreTotalPlays  = new HashMap<>();
        // 장르별 곡 정보
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>();

        // 횟수 저장
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            int play = plays[i];

            // genreTotalPlays에 재생 횟수 더하기
            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);

            // genreSongs에 곡 정보 추가
            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new PriorityQueue<>((s1, s2) -> {
                    if (s1.playCount == s2.playCount) {
                        return Integer.compare(s1.index, s2.index); // 고유 번호 오름차순
                    }
                    return Integer.compare(s2.playCount, s1.playCount); // 재생 횟수 내림차순
                }));
            }
            genreSongs.get(genre).offer(new Song(i, play)); // PriorityQueue에 곡 추가

        }

        // 장르별 총 재생 횟수를 내림차순으로 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((g1, g2) -> genreTotalPlays.get(g2).compareTo(genreTotalPlays.get(g1)));

        // 최대 두 곡씩 선택하기 위한 리스트
        List<Integer> result = new ArrayList<>();

        // 장르별로 최대 두 곡 선택하여 결과에 추가
        for (String genre : sortedGenres) {
            PriorityQueue<Song> pq = genreSongs.get(genre);
            int count = 0;
            while (!pq.isEmpty() && count < 2) {
                result.add(pq.poll().index);
                count++;
            }
        }

        // List를 int[] 배열로 변환하여 반환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}