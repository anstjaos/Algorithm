import java.io.*;

public class BOJ_5597 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        boolean[] isCheck = new boolean[36];

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            isCheck[num] = true;
        }
        br.close();

        for (int i = 1; i <= 30; i++) {
            if (!isCheck[i]) System.out.println(i);
        }
    }
}
