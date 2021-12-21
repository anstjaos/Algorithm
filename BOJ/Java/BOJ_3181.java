import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3181 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        List<String> ignoreWord = new ArrayList<>();
        ignoreWord.add("i");
        ignoreWord.add("pa");
        ignoreWord.add("te");
        ignoreWord.add("ni");
        ignoreWord.add("niti");
        ignoreWord.add("a");
        ignoreWord.add("ali");
        ignoreWord.add("nego");
        ignoreWord.add("no");
        ignoreWord.add("ili");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String curWord = st.nextToken();
            boolean isIgnore = ignoreWord.contains(curWord);
            if (isIgnore && count != 0) continue;

            sb.append((char) (curWord.charAt(0) - 'a' + 'A'));

            count++;
        }
        br.close();
        System.out.println(sb);
    }
}
