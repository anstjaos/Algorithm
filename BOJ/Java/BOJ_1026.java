import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arrA = new int[100];
        int[] arrB = new int[100];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        quickSortAsc(arrA, 0, N-1);
        quickSortDesc(arrB, 0, N-1);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += (arrA[i] * arrB[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result);

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void quickSortAsc(int[] arr, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int pivot = arr[(left + right) / 2];

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

        if (left < rightIndex) quickSortAsc(arr, left, rightIndex);
        if (leftIndex < right) quickSortAsc(arr, leftIndex, right);
    }

    private static void quickSortDesc(int[] arr, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int pivot = arr[(left + right) / 2];

        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] > pivot) leftIndex++;
            while (arr[rightIndex] < pivot) rightIndex--;

            if (leftIndex <= rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }

        if (left < rightIndex) quickSortDesc(arr, left, rightIndex);
        if (leftIndex < right) quickSortDesc(arr, leftIndex, right);
    }
}
