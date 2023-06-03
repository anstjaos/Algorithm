public class lvl2_49993 {
    public int solution(String skill, String[] skill_trees) {
        boolean[] isSkill = new boolean[26];
        for (Character c : skill.toCharArray()) {
            isSkill[c - 'A'] = true;
        }

        int answer = 0;
        for (String cur : skill_trees) {
            int curIndex = 0;
            boolean isPossible = true;
            for (Character c : cur.toCharArray()) {
                if (!isSkill[c - 'A']) continue;

                if (skill.charAt(curIndex) != c) {
                    isPossible = false;
                    break;
                }
                curIndex++;
            }

            if (isPossible) answer++;
        }
        return answer;
    }
}
