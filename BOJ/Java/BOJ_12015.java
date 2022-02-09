import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12015 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        arr.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num > arr.get(arr.size() - 1)) arr.add(num);
            else {
                int left = 0;
                int right = arr.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (arr.get(mid) >= num) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                arr.set(right, num);
            }
        }
        br.close();
        System.out.println(arr.size() - 1);
    }
}
