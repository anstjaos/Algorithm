import java.io.*;

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            boolean[] isVisit = new boolean[30];

            char before = input.charAt(0);
            isVisit[before - 'a'] = true;
            int length = input.length();
            boolean isGroup = true;

            for (int j = 1; j < length; j++) {
                char cur = input.charAt(j);
                if (cur == before) continue;
                if (isVisit[cur - 'a']) {
                    isGroup = false;
                    break;
                }

                before = cur;
                isVisit[cur - 'a'] = true;
            }

            if (isGroup) count++;
        }
        br.close();
        System.out.println(count);
    }
}
