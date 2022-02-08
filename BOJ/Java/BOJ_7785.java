import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> employeeLog = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            employeeLog.put(st.nextToken(), st.nextToken());
        }
        br.close();

        List<Map.Entry<String, String>> leaveList = employeeLog.entrySet().stream()
                .filter(entry -> !entry.getValue().equals("leave"))
                .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> employee : leaveList) {
            sb.append(employee.getKey()).append("\n");
        }

        System.out.print(sb);
    }
}
