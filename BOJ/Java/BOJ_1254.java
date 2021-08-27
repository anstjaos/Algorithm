import java.io.*;

public class BOJ_1254 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        System.out.println(solution(input));
    }

    private static int solution(String input) {

        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (isPalindrome(input.substring(i))) {
                return len+i;
            }
        }
        return len;
    }

    private static boolean isPalindrome(String input) {

        int len = input.length();
        for (int i = 0; i < len/2; i++) {
            if (input.charAt(i) != input.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}
