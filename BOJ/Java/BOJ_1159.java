import java.io.*;

public class BOJ_1159 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] numCount = new int[26];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            numCount[input.charAt(0) - 'a']++;
        }
        br.close();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (numCount[i] >= 5) {
                count++;
                sb.append((char) ('a' + i));
            }
        }

        if (count == 0) System.out.println("PREDAJA");
        else System.out.println(sb);
    }
}
