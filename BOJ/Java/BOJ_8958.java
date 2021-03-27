import java.io.*;

public class BOJ_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            String input = br.readLine();
            int continuesSuccess = 0;
            int inputLen = input.length();

            int result = 0;
            for (int j = 0; j < inputLen; j++) {
                if (input.charAt(j) == 'O') {
                    continuesSuccess += 1;
                    result += continuesSuccess;
                } else {
                    continuesSuccess = 0;
                }
            }
            sb.append(result + "\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
