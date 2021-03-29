import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1181 {
    public static class Dictionary {
        public String word;
        public int length;

        public Dictionary() {}
        public Dictionary(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Dictionary[] dictionaries = new Dictionary[20005];

        int sameCount = 0, index = 0;
        Set<String> sameWord = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (sameWord.contains(word)) {
                sameCount++;
                continue;
            }
            dictionaries[index] = new Dictionary(word, word.length());
            index++;
            sameWord.add(word);
        }
        N -= sameCount;

        quickSortLength(dictionaries, 0, N-1);

        int start = 0;
        for (int i = 1; i < N; i++) {
            if (dictionaries[start].length != dictionaries[i].length) {
                if (start != i - 1) {
                    quickSortWord(dictionaries, start, i-1);
                }
                start = i;
            }
        }

        if (start != N -1) {
            quickSortWord(dictionaries, start, N-1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(dictionaries[i].word + "\n");
        System.out.println(sb.toString());
        br.close();
    }

    private static void quickSortWord(Dictionary[] dictionaries, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        String pivot = dictionaries[(left+right)/2].word;

        while (leftIndex <= rightIndex) {
            while (dictionaries[leftIndex].word.compareTo(pivot) < 0) leftIndex++;
            while (dictionaries[rightIndex].word.compareTo(pivot) > 0) rightIndex--;

            if (leftIndex <= rightIndex) {
                Dictionary temp = dictionaries[leftIndex];
                dictionaries[leftIndex] = dictionaries[rightIndex];
                dictionaries[rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }

        if (left < rightIndex) quickSortWord(dictionaries, left, rightIndex);
        if (leftIndex < right) quickSortWord(dictionaries, leftIndex, right);
    }

    private static void quickSortLength(Dictionary[] dictionaries, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int pivot = dictionaries[(left+right)/2].length;

        while (leftIndex <= rightIndex) {
            while (dictionaries[leftIndex].length < pivot) leftIndex++;
            while (dictionaries[rightIndex].length > pivot) rightIndex--;

            if (leftIndex <= rightIndex) {
                Dictionary temp = dictionaries[leftIndex];
                dictionaries[leftIndex] = dictionaries[rightIndex];
                dictionaries[rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }

        if (left < rightIndex) quickSortLength(dictionaries, left, rightIndex);
        if (leftIndex < right) quickSortLength(dictionaries, leftIndex, right);
    }
}
