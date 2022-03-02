import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_9584 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String code = br.readLine();
        int N = Integer.parseInt(br.readLine());

        List<String> result = new ArrayList<>();

        while (N-- > 0) {
            String input = br.readLine();

            boolean isFind = true;
            for (int i = 0; i < 9; i++) {
                if (code.charAt(i) == '*') continue;

                if (code.charAt(i) != input.charAt(i)) {
                    isFind = false;
                    break;
                }
            }

            if (isFind) {
                result.add(input);
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();

        sb.append(result.size()).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}
