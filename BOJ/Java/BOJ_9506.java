import java.io.*;

public class BOJ_9506 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) break;

            int sum = 1;
            boolean[] isDivide = new boolean[num + 1];
            isDivide[1] = true;

            int maxNum = -1;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isDivide[i] = true;
                    isDivide[num / i] = true;
                    sum += i;
                    if (num / i != i) {
                        sum += num / i;
                    }
                    maxNum = Math.max(maxNum, num / i);
                }
            }

            if (sum == num) {
                sb.append(num).append(" = ");
                for (int i = 1; i <= maxNum; i++) {
                    if (isDivide[i]) {
                        sb.append(i);
                        if (i != maxNum) {
                            sb.append(" + ");
                        }
                    }
                }
                sb.append("\n");
            } else {
                sb.append(num).append(" is NOT perfect.\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
