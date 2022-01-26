import java.io.*;

public class BOJ_5904 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(solve(N));
    }

    private static char solve(int num) {
        if (num == 1) return 'm';
        else if (num <= 3) return 'o';

        int size = 3;
        int index = 0;

        while (size < num) {
            size = size * 2 + index + 4;
            index++;
        }

        int front = (size - index - 3) / 2;
        if (size - front + 1 <= num) {
            return solve(num - size + front);
        } else if (num == front + 1) return 'm';

        return 'o';
    }
}
