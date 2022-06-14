import java.util.*;

public class lvl1_92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportCountMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
            reportCountMap.put(id_list[i], 0);
        }

        for (int i = 0; i < report.length; i++) {
            String[] splitReport = report[i].split(" ");
            Set<String> reportSet = reportMap.get(splitReport[0]);

            if (!reportSet.contains(splitReport[1])) {
                reportSet.add(splitReport[1]);
                reportCountMap.replace(splitReport[1], reportCountMap.get(splitReport[1]) + 1);
                reportMap.replace(splitReport[0], reportSet);
            }
        }

        String[] reportUser = new String[id_list.length];
        int count = 0;

        for (int i = 0; i < id_list.length; i++) {
            if (reportCountMap.get(id_list[i]) >= k) {
                reportUser[count++] = id_list[i];
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            int result = 0;
            Set<String> reportSet = reportMap.get(id_list[i]);

            for (int j = 0; j < count; j++) {
                if (reportSet.contains(reportUser[j])) {
                    result++;
                }
            }
            answer[i] = result;
        }
        return answer;
    }
}
