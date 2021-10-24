import java.io.*;

public class BOJ_8741 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int k = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(1);
        for (int i = 0; i < k -1; i++) sb.append(0);

        System.out.println(sb);
    }
}
