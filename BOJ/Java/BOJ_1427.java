import java.io.*;

public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[15];
        int index = 0;
        while(N > 0) {
            arr[index++] = N % 10;
            N /= 10;
        }

        quickSort(arr, 0, index - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb.toString());
        br.close();
    }

    private static void quickSort(int[] arr, int left, int right) {
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

        if (left < rightIndex) quickSort(arr, left, rightIndex);
        if (leftIndex < right) quickSort(arr, leftIndex, right);
    }
}
