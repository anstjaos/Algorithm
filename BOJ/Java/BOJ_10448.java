import java.io.*;

public class BOJ_10448 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] arr = new int[50];
        int sum = 2;
        arr[0] = 1;
        for (int i = 1; i < 50; i++) {
            arr[i] = arr[i-1] + sum;
            sum++;
        }
        boolean[] check = new boolean[1001];

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                for (int k = 0; k < 50; k++) {
                    int index = arr[i] + arr[j] + arr[k];
                    if (index > 1000) continue;

                    check[index] = true;
                }
            }
        }

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(br.readLine());

            if (check[num]) sb.append("1\n");
            else sb.append("0\n");
        }
        br.close();
        System.out.print(sb);
    }
}
