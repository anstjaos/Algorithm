import java.io.*;

public class BOJ_10769 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int happyCount = 0, sadCount = 0;

        String input = br.readLine();
        br.close();

        int length = input.length();
        for (int i = 0; i < length - 2; i++) {
            if (input.charAt(i) == ':' && input.charAt(i + 1) == '-') {
                if (input.charAt(i+2) == ')') happyCount++;
                else if (input.charAt(i + 2) == '(') sadCount++;
            }
        }

        if (happyCount == 0 && sadCount == 0) System.out.println("none");
        else if (happyCount == sadCount) System.out.println("unsure");
        else if (happyCount > sadCount) System.out.println("happy");
        else System.out.println("sad");
    }
}
