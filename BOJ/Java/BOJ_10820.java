import java.io.*;

public class BOJ_10820 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String input = "";
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            int[] arr = new int[4];
            int len = input.length();

            for (int i = 0; i < len; i++) {
                char cur = input.charAt(i);

                if ('a' <= cur && cur <= 'z') arr[0]++;
                else if ('A' <= cur && cur <= 'Z') arr[1]++;
                else if ('0' <= cur && cur <= '9') arr[2]++;
                else if (cur == ' ') arr[3]++;
            }

            sb.append(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + "\n");
        }
        br.close();
        System.out.print(sb);
    }
}
