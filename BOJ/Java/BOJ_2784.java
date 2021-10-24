import java.io.*;
import java.util.Arrays;

public class BOJ_2784 {
    private static String[] result, arr;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        arr = new String[6];
        for (int i = 0; i < 6; i++) arr[i] = br.readLine();
        br.close();

        Arrays.sort(arr);
        result = new String[3];
        visit = new boolean[6];

        boolean isSolve = solve(0);

        StringBuilder sb = new StringBuilder();
        if (isSolve) {
            for (int i = 0; i < 3; i++) sb.append(result[i]).append("\n");
        } else sb.append("0\n");

        System.out.print(sb);
    }

    private static boolean solve(int index) {
        if (index == 3) {
            boolean isVisit[] = new boolean[6];
            for (int j = 0; j < 6; j++) isVisit[j] = visit[j];

            for (int i = 0; i < 3; i++) {
                String word = "";
                for (int j = 0; j < 3; j++) {
                    word += result[j].charAt(i);
                }

                boolean isFind = false;

                for (int j = 0; j < 6; j++) {
                    if (isVisit[j]) continue;

                    if (word.equals(arr[j])) {
                        isFind = true;
                        isVisit[j] = true;
                        break;
                    }
                }
                if (!isFind) return false;
            }
            return true;
        }

        for (int i = 0; i < 6; i++) {
            if (visit[i]) continue;

            result[index] = arr[i];
            visit[i] = true;
            boolean isSolve = solve(index + 1);
            if (isSolve) return true;
            visit[i] = false;
        }
        return false;
    }
}
