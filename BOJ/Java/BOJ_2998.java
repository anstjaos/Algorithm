import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2998 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Map<String, Integer> octaMap = new HashMap<>();
        octaMap.put("000", 0);
        octaMap.put("001", 1);
        octaMap.put("010", 2);
        octaMap.put("011", 3);
        octaMap.put("100", 4);
        octaMap.put("101", 5);
        octaMap.put("110", 6);
        octaMap.put("111", 7);

        String input = br.readLine();
        int length = input.length();
        if (length % 3 != 0) {
            for (int i = 0; i < 3 - length % 3; i++) {
                input = "0".concat(input);
            }
        }
        StringBuilder sb = new StringBuilder();
        length = input.length();
        for (int i = 0; i < length; i += 3) {
            String cur = input.substring(i, i + 3);
            sb.append(octaMap.get(cur));
        }

        br.close();
        System.out.println(sb);
    }
}
