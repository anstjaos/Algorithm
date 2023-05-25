import java.util.*;

public class lvl3_64064 {
    String[] userIds;
    String[] bannedIds;
    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;

        dfs(new HashSet<>(), 0);

        return result.size();
    }

    void dfs(Set<String> set, int depth) {
        if (depth == bannedIds.length) {
            result.add(set);
            return;
        }

        for (String userId : userIds) {
            if (set.contains(userId)) {
                continue;
            }

            if (check(userId, bannedIds[depth])) {
                set.add(userId);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userId);
            }
        }
    }

    boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        boolean match = true;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                match = false;
                break;
            }
        }

        return match;
    }
}
