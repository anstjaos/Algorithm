import java.io.*;

public class BOJ_2661 {
    private static int N;
    private static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();

        solve("");
        System.out.println(result);
    }

    private static boolean solve(String str) {
        if (str.length() == N) {
            result = str;
            return true;
        }

        for (int i = 1; i <= 3; i++) {
            if (isPossible(str + i)) {
                if (solve(str + i)) return true;
            }
        }

        return false;
    }

    private static boolean isPossible(String str) {
        int len = str.length();

        for (int i = 1; i <= len / 2; i++) {
            String front = str.substring(len - i - i, len - i);
            String back = str.substring(len - i, len);

            if (front.equals(back)) return false;
        }

        return true;
    }
}
