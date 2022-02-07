import java.io.*;

public class BOJ_17294 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        int length = input.length();
        boolean result = true;
        int diff = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            int diffTemp = (input.charAt(i + 1) - '0') - (input.charAt(i) - '0');
            if (i == 0) {
                diff = diffTemp;
                continue;
            }

            if (diffTemp != diff) {
                result = false;
                break;
            }
        }

        System.out.println(result ? "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!" : "흥칫뿡!! <(￣ ﹌ ￣)>");
    }
}
