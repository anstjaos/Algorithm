import java.io.*;

public class BOJ_2992 {
    private static int[] numCount = new int[10];
    private static int X, len, result;

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        X = Integer.parseInt(br.readLine());
        len = 0;
        result = Integer.MAX_VALUE;
        br.close();

        int temp = X;
        while (temp != 0) {
            numCount[temp % 10]++;
            temp /= 10;
            len++;
        }

        solve(0, 0);
        if (result == Integer.MAX_VALUE) result = 0;
        System.out.println(result);
    }

    private static void solve(int num, int count) {
        if (count == len) {
            if (num <= X) return;

            result = Math.min(result, num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 0 && count == 0) continue;
            if (numCount[i] == 0) continue;

            numCount[i]--;
            int temp = num * 10 + i;
            solve(temp, count + 1);
            numCount[i]++;
        }
    }
}
