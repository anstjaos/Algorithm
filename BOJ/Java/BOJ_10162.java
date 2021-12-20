import java.io.*;

public class BOJ_10162 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());
        br.close();

        int[] arr = new int[3];
        if (T >= 300) {
            arr[0] = T / 300;
            T = T - (300 * arr[0]);
        }

        if (T >= 60) {
            arr[1] = T / 60;
            T = T - (60 * arr[1]);
        }

        if (T >= 10) {
            arr[2] = T / 10;
            T = T - (10 * arr[2]);
        }

        if (T != 0) System.out.println(-1);
        else {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
    }
}
