import java.io.*;

public class BOJ_2154 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(i);
        br.close();

        System.out.println(sb.toString().indexOf(String.valueOf(N)) + 1);
    }
}
