import java.io.*;

public class BOJ_7891 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            sb.append(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1])).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
