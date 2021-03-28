import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[105];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int maxSum = -1;

        quickSort(arr, 0, N-1);
        for (int i = 0 ; i < N ;i++) {
            for (int j = i +1; j < N; j++) {
                if (arr[i] + arr[j] > M) break;
                for (int k = j + 1; k < N; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (temp > M) break;

                    maxSum = Math.max(maxSum, temp);
                }
            }
        }

        System.out.println(maxSum);
        br.close();
    }

    private static void quickSort(int[] arr, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int pivot = arr[(left+right)/2];

        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < pivot) leftIndex++;
            while (arr[rightIndex] > pivot) rightIndex--;

            if (leftIndex <= rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }

        if (left < rightIndex) quickSort(arr, left, rightIndex);
        if (leftIndex < right) quickSort(arr, leftIndex, right);
    }
}
