import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15501 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] arr1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr1[i] = Integer.parseInt(st.nextToken());
        br.close();

        int startIdx = 0;
        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr[0]) {
                startIdx = i;
                break;
            }
        }

        boolean isGood = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] != arr1[(startIdx + i) % n]) {
                isGood = false;
                break;
            }
        }

        if (isGood) {
            System.out.println("good puzzle");
        } else {
            isGood = true;
            for (int i = 0; i < n; i++) {
                if (arr[i] != arr1[(startIdx - i + n) % n]) {
                    isGood = false;
                    break;
                }
            }

            if (isGood) System.out.println("good puzzle");
            else System.out.println("bad puzzle");
        }
    }
}
