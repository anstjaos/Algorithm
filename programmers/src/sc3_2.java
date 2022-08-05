import java.util.*;

public class sc3_2 {
    boolean[] visited;
    List<String> answers;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answers = new ArrayList<String>();
        int count = 0;
        dfs(count, "ICN", "ICN", tickets);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
    }

    public void dfs(int count, String present, String answer, String[][]ticktes) {
        if(count == ticktes.length) {
            answers.add(answer);
            return;
        }

        for(int i = 0; i < ticktes.length; i++) {
            if(!visited[i] && ticktes[i][0].equals(present)) {
                visited[i] = true;
                dfs(count+1, ticktes[i][1], answer+" "+ticktes[i][1], ticktes);
                visited[i] = false;
            }
        }
    }
}
