import java.io.*;
import java.util.*;

public class BOJ_1208 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        List<Long> aList = new ArrayList<>();
        List<Long> bList = new ArrayList<>();

        dfs(0, N/2, 0, aList);
        dfs(N/2, N, 0, bList);

        Collections.sort(aList);
        Collections.sort(bList);

        int left = 0, right = bList.size() - 1;
        long sum = 0;

        long result = 0;
        while (left < aList.size() && right >= 0) {
            long leftVal = aList.get(left), rightVal = bList.get(right);
            sum = leftVal + rightVal;

            if (sum == S) {
                long leftCount = 0, rightCount = 0;

                while (left < aList.size() && aList.get(left) == leftVal) {
                    left++;
                    leftCount++;
                }

                while (right >= 0 && bList.get(right) == rightVal) {
                    right--;
                    rightCount++;
                }

                result += leftCount * rightCount;
            } else if (sum < S) {
                left++;
            } else if (sum > S) {
                right--;
            }
        }

        if (S == 0) System.out.println(result - 1);
        else System.out.println(result);
    }

    private static void dfs(int cur, int end, long sum, List<Long> list) {
        if (cur == end) {
            list.add(sum);
            return;
        }

        dfs(cur + 1, end, sum + arr[cur], list);
        dfs(cur + 1, end, sum, list);
    }
}
