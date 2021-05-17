import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) arrB[i] = Integer.parseInt(st.nextToken());
        br.close();

        List<Integer> aSum = getSum(arrA);
        List<Integer> bSum = getSum(arrB);

        Collections.sort(aSum);
        Collections.sort(bSum);

        long result = 0;
        for (Integer a : aSum) {
            int val = T - a;
            int upper = getUpperBound(bSum, val);
            int lower = getLowerBound(bSum, val);
            result += upper - lower;
        }

        System.out.println(result);
    }

    private static List<Integer> getSum(int[] arr) {
        List<Integer> result = new ArrayList<>();

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += arr[j];
                result.add(sum);
            }
        }

        return result;
    }

    private static int getUpperBound(List<Integer> list, int value) {
        int left = 0, right = list.size(), mid = 0;

        while (left < right) {
            mid = (left + right) >> 1;

            if (list.get(mid) <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private static int getLowerBound(List<Integer> list, int value) {
        int left = 0, right = list.size(), mid = 0;

        while (left < right) {
            mid = (left + right) >> 1;

            if (list.get(mid) >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
