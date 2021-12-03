import java.io.*;

public class BOJ_3040 {
    private static int[] arr;
    private static boolean[] isSelect;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        arr = new int[9];
        isSelect = new boolean[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        solve(0, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (isSelect[i]) sb.append(arr[i]).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean solve(int sum, int idx, int count) {
        if (count == 7) {
            if (sum == 100) return true;
            return false;
        }
        if (idx == 9) return false;


        for (int i = idx; i < 9; i++) {
            isSelect[i] = true;
            if (solve(sum + arr[i], i + 1, count + 1)) return true;
            isSelect[i] = false;
        }
        return false;
    }
}
