import java.io.*;

public class BOJ_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        if (N >= 100) {
            result = 99;
            for (int i = 111; i <= N; i++) {
                String num = String.valueOf(i);
                int size = num.length();
                int diff = num.charAt(1) - num.charAt(0);
                boolean isSuccess = true;
                for (int j = 2; j < size; j++) {
                    int temp = num.charAt(j) - num.charAt(j-1);
                    if (diff != temp) {
                        isSuccess = false;
                        break;
                    }
                }

                if (isSuccess) result++;
            }
        } else result = N;

        System.out.println(result);
    }
}
