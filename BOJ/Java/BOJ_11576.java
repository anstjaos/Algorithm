import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11576 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int num = 0;
        for (int i = 0; i < m; i++) {
            num += Integer.parseInt(st.nextToken()) * Math.pow(A, m - i - 1);
        }
        br.close();

        List<Integer> arr = new ArrayList<>();
        while (num != 0) {
            arr.add(num % B);
            num /= B;
        }

        StringBuilder sb = new StringBuilder();
        int length = arr.size();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(arr.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
