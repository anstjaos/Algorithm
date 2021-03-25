import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {

    public static class Alphabet {
        public int count;
        public int index;

        public Alphabet(int count, int index) {
            this.count = count;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();

        int[] arr = new int[30];
        int length = input.length();

        for (int i = 0; i < length; i++) {
            arr[input.charAt(i) - 'a']++;
        }

        Alphabet[] alphabets = new Alphabet[30];
        for (int i = 0; i< 26; i++) {
            alphabets[i] = new Alphabet(arr[i], i);
        }

        quickSort(alphabets, 0, 25);

        if (alphabets[0].count == alphabets[1].count) System.out.println("?");
        else {
            char result = (char) ('A' + alphabets[0].index);
            System.out.println(result);
        }
        br.close();
    }

    private static void quickSort(Alphabet[] arr, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int pivot = arr[(left+ right) /2].count;

        while (leftIndex <= rightIndex) {
            while (arr[leftIndex].count > pivot) leftIndex++;
            while (arr[rightIndex].count < pivot) rightIndex--;

            if (leftIndex <= rightIndex) {
                Alphabet temp = arr[leftIndex];
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
