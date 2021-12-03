import java.io.*;

public class BOJ_1475 {
    private static int[] count;
    private static int setCount;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input = br.readLine();
        br.close();

        count = new int[10];
        int length = input.length();

        setCount = 0;
        for (int i = 0; i < length; i++) {
            int cur = input.charAt(i) - '0';

            if (count[cur] == 0) {
                if (cur == 6) {
                    if (count[9] == 0) {
                        addSet();
                        count[cur]--;
                    } else count[9]--;
                } else if (cur == 9) {
                    if (count[6] == 0) {
                        addSet();
                        count[cur]--;
                    }
                    else count[6]--;
                } else {
                    addSet();
                    count[cur]--;
                }
            } else count[cur]--;
        }

        System.out.println(setCount);
    }

    private static void addSet() {
        for (int i = 0; i < 10; i++) count[i]++;
        setCount++;
    }
}
