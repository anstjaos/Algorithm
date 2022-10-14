import java.io.*;

public class BOJ_25314 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            sb.append("long ");
            N -= 4;
        }
        sb.append("int");
        br.close();
        System.out.println(sb);
    }
}
