import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1373 {
    private static List<Integer> arr;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        arr = new ArrayList<>();
        int idx = input.length();

        while (idx > 0) {
            int begin = idx - 3;
            if (begin < 0) begin = 0;
            arr.add(getOctoNum(input.substring(begin, idx)));
            idx -= 3;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = arr.size() - 1; i >= 0; i--) sb.append(arr.get(i));
        System.out.println(sb);
    }

    private static int getOctoNum(String num) {
        int length = num.length() - 1;
        int result = 0, multi = 1;
        for (int i = length; i >= 0; i--) {
            result += (num.charAt(i) - '0') * multi;
            multi *= 2;
        }

        return result;
    }
}
