import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14696 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] aCard = new int[5];
            int[] bCard = new int[5];

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int num = Integer.parseInt(st.nextToken());
                aCard[num]++;
            }

            st = new StringTokenizer(br.readLine());
            count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int num = Integer.parseInt(st.nextToken());
                bCard[num]++;
            }

            if (aCard[4] > bCard[4]) sb.append("A");
            else if (aCard[4] < bCard[4]) sb.append("B");
            else if (aCard[3] > bCard[3]) sb.append("A");
            else if (aCard[3] < bCard[3]) sb.append("B");
            else if (aCard[2] > bCard[2]) sb.append("A");
            else if (aCard[2] < bCard[2]) sb.append("B");
            else if (aCard[1] > bCard[1]) sb.append("A");
            else if (aCard[1] < bCard[1]) sb.append("B");
            else sb.append("D");

            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
