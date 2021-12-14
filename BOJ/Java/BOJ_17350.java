import java.io.*;

public class BOJ_17350 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        boolean isFind = false;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("anj")) isFind = true;
        }
        br.close();
        System.out.println(isFind ? "뭐야;" : "뭐야?");
    }
}
