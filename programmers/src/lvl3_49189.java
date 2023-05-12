import java.util.*;

public class lvl3_49189 {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int [] e : edge) {
            List<Integer> list = map.getOrDefault(e[0], new ArrayList<>());
            list.add(e[1]);
            map.put(e[0], list);

            list = map.getOrDefault(e[1], new ArrayList<>());
            list.add(e[0]);
            map.put(e[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int answer = 0;
        boolean[] isVisit = new boolean[20005];
        isVisit[1] = true;
        while (!queue.isEmpty()) {
            answer = queue.size();

            for (int i = 0; i < answer; i++) {
                Integer cur = queue.poll();

                List<Integer> vertex = map.get(cur);
                for (Integer v : vertex) {
                    if (isVisit[v]) continue;

                    isVisit[v] = true;
                    queue.offer(v);
                }
            }
        }

        return answer;
    }
}
