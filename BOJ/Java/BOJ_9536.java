import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_9536 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            List<String> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                arr.add(st.nextToken());
            }

            while (true) {
                String input = br.readLine();
                if (input.equals("what does the fox say?")) break;

                input = input.split(" ")[2];

                String finalInput = input;
                arr = arr.stream().filter(str -> !str.equals(finalInput)).collect(Collectors.toList());
            }

            for (String str : arr) sb.append(str).append(" ");
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
