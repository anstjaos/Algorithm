import java.io.*;

public class BOJ_5586 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int joiCnt = 0, ioiCnt = 0;

        String input = br.readLine();
        int length = input.length();

        for (int i = 0; i < length-2; i++) {
            char cur = input.charAt(i);

            if (input.charAt(i + 1) == 'O' && input.charAt(i + 2) == 'I') {
                if (cur == 'J') {
                    joiCnt++;
                } else if (cur == 'I') {
                    ioiCnt++;
                }
            }
        }
        br.close();
        System.out.println(joiCnt);
        System.out.println(ioiCnt);
    }
}
