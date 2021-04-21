import java.io.*;
import java.util.*;

public class BOJ_1107 {
    private static List<Integer> remoteControl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());

        boolean[] notInclude = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                notInclude[Integer.parseInt(st.nextToken())] = true;
            }
        }
        remoteControl = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (!notInclude[i]) remoteControl.add(i);
        }

        int result = Math.abs(N - 100);
        for(int i = 0; i <= 1000000; i++) {
            int length = chk(i);

            if(length > 0) result = Math.min(result, Math.abs(N - i) + length);
        }

        System.out.println(result);
        br.close();
    }

    private static int chk(int num) {
        int length = 0;
        if(num == 0) return !remoteControl.contains(num)? 0 : 1;

        while(num > 0) {
            if(!remoteControl.contains(num % 10)) return 0;

            length++;
            num /= 10;
        }
        return length;
    }
}
