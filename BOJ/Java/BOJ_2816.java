import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2816 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();

        int kbs1Idx = 0, kbs2Idx = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            arr.add(input);

            if (input.equals("KBS1")) {
                kbs1Idx = i;
            } else if (input.equals("KBS2")) {
                kbs2Idx = i;
            }
        }
        if (kbs1Idx > kbs2Idx) kbs2Idx++;
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < kbs1Idx; i++) {
            sb.append(1);
        }

        for (int i = kbs1Idx; i > 0; i--) {
            sb.append(4);
        }

        for (int i = 0; i < kbs2Idx; i++) {
            sb.append(1);
        }

        for (int i = kbs2Idx; i > 1; i--) {
            sb.append(4);
        }

        System.out.println(sb);
    }
}
