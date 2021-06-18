import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(br.readLine());
        boolean[] switchArr = new boolean[switchCount + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < switchCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) switchArr[i+1] = true;
            else switchArr[i + 1] = false;
        }

        int studentCount = Integer.parseInt(br.readLine());
        while (studentCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken()), num = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                for (int i = 1; i <= switchCount; i++) {
                    if ((i % num) != 0) continue;

                    switchArr[i] = !switchArr[i];
                }
            } else {
                int size = 0;
                while (true) {
                    int left = num - size;
                    int right = num + size;
                    if (left <= 0 || right > switchCount) break;
                    if (switchArr[left] != switchArr[right]) break;

                    size++;
                }

                switchArr[num] = !switchArr[num];
                for (int i = 1; i < size; i++) {
                    int left = num - i;
                    int right = num + i;

                    switchArr[left] = !switchArr[left];
                    switchArr[right] = !switchArr[right];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= switchCount; i++) {
            if (switchArr[i]) sb.append(1);
            else sb.append(0);

            if (i % 20 == 0) sb.append("\n");
            else sb.append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
