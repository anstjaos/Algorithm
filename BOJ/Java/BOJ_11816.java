import java.io.*;

public class BOJ_11816 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();

        br.close();
        if (input.charAt(0) != '0') System.out.println(input);
        else {
            int len = input.length();
            int result = 0;
            if (input.charAt(1) != 'x') {
                int multi = 1;
                for (int i = len - 1; i >= 1; i--) {
                    result += (input.charAt(i) - '0') * multi;
                    multi *= 8;
                }
            } else {
                int multi = 1;
                for (int i = len - 1; i >= 2; i--) {
                    int num = 0;
                    switch (input.charAt(i)) {
                        case 'a':
                            num = 10;
                            break;
                        case 'b' :
                            num = 11;
                            break;
                        case 'c':
                            num = 12;
                            break;
                        case 'd':
                            num = 13;
                            break;
                        case 'e':
                            num = 14;
                            break;
                        case 'f':
                            num = 15;
                            break;
                        default:
                            num = (input.charAt(i) - '0');
                            break;
                    }
                    result += num * multi;
                    multi *= 16;
                }
            }
            System.out.println(result);
        }
    }
}
