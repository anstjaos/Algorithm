import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1431 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        List<String> guitars = new ArrayList<>();

        for (int i = 0; i < N; i++) guitars.add(br.readLine());
        br.close();

        guitars.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }

            int s1Sum = 0, s2Sum = 0;
            for (int i = 0; i < s1.length(); i++) {
                char cur = s1.charAt(i);
                if ('0' <= cur && cur <= '9') {
                    s1Sum += (cur - '0');
                }
            }
            for (int i = 0; i < s2.length(); i++) {
                char cur = s2.charAt(i);
                if ('0' <= cur && cur <= '9') {
                    s2Sum += (cur - '0');
                }
            }

            if (s1Sum != s2Sum) {
                return s1Sum - s2Sum;
            }

            return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(guitars.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}
