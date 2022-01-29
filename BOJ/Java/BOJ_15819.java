import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15819 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        List<String> handleList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            handleList.add(br.readLine());
        }
        br.close();

        Collections.sort(handleList);
        System.out.println(handleList.get(K-1));
    }
}
