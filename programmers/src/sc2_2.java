import java.util.Arrays;

public class sc2_2 {
    public int solution(String skill, String[] skill_trees) {
        int[] beforeSkill = new int[26];
        Arrays.fill(beforeSkill, -1);

        int before = -1;
        for (int i = 0; i < skill.length(); i++) {
            int cur = (int)(skill.charAt(i) - 'A');
            beforeSkill[cur] = before;
            before = cur;
        }

        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            String cur = skill_trees[i];
            boolean[] isLearned = new boolean[26];
            boolean isPossible = true;
            for (int j = 0; j < cur.length(); j++) {
                int curIdx = (int)(cur.charAt(j) - 'A');
                int beforeIdx = beforeSkill[curIdx];
                isLearned[curIdx] = true;

                if (beforeIdx == -1) continue;

                if (!isLearned[beforeIdx]) {
                    isPossible = false;
                    break;
                }

            }

            if (isPossible) answer++;
        }
        return answer;
    }
}
