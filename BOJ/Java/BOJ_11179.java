import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11179 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        List<Integer> arr = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        br.close();

        while (N > 0) {
            arr.add(N % 2);
            N /= 2;
        }

        int length = arr.size(), multi = 1;
        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
           result += arr.get(i) * multi;
           multi *= 2;
        }

        System.out.println(result);
    }
}
