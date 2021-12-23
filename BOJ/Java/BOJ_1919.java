import java.io.*;

public class BOJ_1919 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String A = br.readLine(), B = br.readLine();

        int[] aCount = new int[26];
        int[] bCount = new int[26];
        br.close();

        for (int i = 0; i < A.length(); i++) {
            aCount[A.charAt(i) - 'a']++;
        }
        for (int i = 0; i < B.length(); i++) {
            bCount[B.charAt(i) - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(aCount[i] - bCount[i]);
        }

        System.out.println(result);
    }
}
