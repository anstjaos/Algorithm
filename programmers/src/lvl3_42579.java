import java.util.*;

public class lvl3_42579 {
    class Music {
        int play;
        int index;

        public Music(int play, int index) {
            this.play = play;
            this.index = index;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresPlayMap = new HashMap<>();
        Map<String, List<Music>> genresMusicsMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            genresPlayMap.put(genres[i], genresPlayMap.getOrDefault(genres[i], 0) + plays[i]);
            List<Music> musics = genresMusicsMap.getOrDefault(genres[i], new ArrayList<>());
            musics.add(new Music(plays[i], i));
            genresMusicsMap.put(genres[i], musics);
        }

        List<Integer> answer = new ArrayList<>();
        List<Map.Entry<String, Integer>> genresPlayList = new ArrayList<>(genresPlayMap.entrySet());
        genresPlayList.sort(Map.Entry.comparingByValue());

        for (int i = genresPlayList.size() - 1; i >= 0; i--) {
            String genre = genresPlayList.get(i).getKey();
            List<Music> musicList = genresMusicsMap.get(genre);
            musicList.sort((a, b) -> {
                if (b.play == a.play) {
                    return a.index - b.index;
                }
                return b.play - a.play;
            });

            int max = Math.min(2, musicList.size());
            for (int j = 0; j < max; j++) {
                answer.add(musicList.get(j).index);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
