import java.io.*;

public class BOJ_1907 {
    private static int[] m3Arr;
    private static int[] m1Arr, m2Arr;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        String M3 = input.split("=")[1];
        input = input.split("=")[0];

        String M1 = input.split("\\+")[0], M2 = input.split("\\+")[1];

        m3Arr = new int[3];
        init(M3, m3Arr);
        br.close();

        m1Arr = new int[3];
        init(M1, m1Arr);

        m2Arr = new int[3];
        init(M2, m2Arr);

        int m1Count = 1, m2Count = 1, m3Count = 1;

        boolean isSolve = false;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 10; k++) {
                    if (solve(i, j, k)) {
                        m1Count = i;
                        m2Count = j;
                        m3Count = k;

                        isSolve = true;
                        break;
                    }
                }
                if (isSolve) break;
            }
            if (isSolve) break;
        }

        System.out.println(m1Count + " " + m2Count + " " + m3Count);
    }

    private static void init(String str, int[] arr) {
        char before = 'a';
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            switch (cur) {
                case 'C':
                case 'H':
                case 'O':
                    checkBefore(before, arr, 1);
                    break;
                default:
                    int num = cur - '0';
                    checkBefore(before, arr, num);
                    break;
            }
            before = cur;
        }

        int num = 1;
        if ('0' <= before && before <= '9') num = before - '0';
        checkBefore(before, arr, num);
    }

    private static void checkBefore(char before, int[] arr, int num) {
        if (before == 'C') {
            arr[0] += num;
        } else if (before == 'H') {
            arr[1] += num;
        } else if (before == 'O') {
            arr[2] += num;
        }
    }

    private static boolean solve(int m1Count, int m2Count, int m3Count){
        if (((m1Arr[0] * m1Count) + (m2Arr[0] * m2Count)) == (m3Arr[0] * m3Count)
                && ((m1Arr[1] * m1Count) + (m2Arr[1] * m2Count)) == (m3Arr[1] * m3Count)
                && ((m1Arr[2] * m1Count) + (m2Arr[2] * m2Count)) == (m3Arr[2] * m3Count)) return true;

        return false;
    }
}
