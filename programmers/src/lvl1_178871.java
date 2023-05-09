import java.util.HashMap;
import java.util.Map;

public class lvl1_178871 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerRank = new HashMap<>();
        Map<Integer, String> rankPlayer = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerRank.put(players[i], i);
            rankPlayer.put(i, players[i]);
        }

        for (String player : callings) {
            int rank = playerRank.get(player);
            String before = rankPlayer.get(rank - 1);

            playerRank.put(player, rank - 1);
            playerRank.put(before, rank);

            rankPlayer.put(rank - 1, player);
            rankPlayer.put(rank, before);
        }

        String[] answer = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            answer[i] = rankPlayer.get(i);
        }

        return answer;
    }
}
