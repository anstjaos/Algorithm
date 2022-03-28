import java.io.*;

public class BOJ_3613 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        int length = input.length();

        boolean isJava = false, isCplus = false, isWrong = false;

        if (input.charAt(0) < 'a' || input.charAt(0) > 'z') {
            System.out.println("Error!");
            return;
        }

        for(int i = 1; i < length; i++) {
            char c = input.charAt(i);
            if(c == '_') {
                if(isJava) {
                    isWrong = true;
                    break;
                }

                if(i == length - 1) {
                    isWrong = true;
                    break;
                } else if(input.charAt(i + 1) == '_') {
                    isWrong = true;
                    break;
                } else {
                    isCplus = true;
                }
            } else if('A' <= c && c <= 'Z') {
                if(isCplus) {
                    isWrong = true;
                    break;
                } else {
                    isJava = true;
                }
            }
        }
        br.close();

        if (isWrong) {
            System.out.println("Error!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char cur = input.charAt(i);

            if (isCplus) {
                if (cur == '_') {
                    i++;
                    if (i < length) sb.append((char) (input.charAt(i) - 'a' + 'A'));
                } else sb.append(cur);
            } else {
                if ('A' <= cur && cur <= 'Z') sb.append("_").append((char) (cur - 'A' + 'a'));
                else sb.append(cur);
            }
        }

        System.out.println(sb);
    }
}
