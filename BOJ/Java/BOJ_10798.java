import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10798 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        List<String> arr = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            maxLength = Math.max(maxLength, input.length());
            arr.add(input);
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr.get(j).length() <= i) continue;

                sb.append(arr.get(j).charAt(i));
            }
        }

        System.out.println(sb);
    }
}
