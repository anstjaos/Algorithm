import java.io.*;

public class BOJ_2562 {
    public static class Number {
        public int num;
        public int index;

        public Number(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Number[] numArr = new Number[15];
        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            numArr[i] = new Number(num, i);
        }

        quickSort(numArr, 1, 9);
        StringBuilder sb = new StringBuilder();
        sb.append(numArr[1].num + "\n");
        sb.append(numArr[1].index);

        System.out.println(sb.toString());
        br.close();
    }

    public static void quickSort(Number[] arr, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int pivot = arr[(left+right) / 2].num;

        while (leftIndex <= rightIndex) {
            while (arr[leftIndex].num > pivot) leftIndex++;
            while (arr[rightIndex].num < pivot) rightIndex--;

            if (leftIndex <= rightIndex) {
                Number temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }

            if (left < rightIndex) quickSort(arr, left, rightIndex);
            if (leftIndex < right) quickSort(arr, leftIndex, right);
        }
    }
}
