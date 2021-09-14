import java.io.*;

public class BOJ_10886 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int cute = 0, notCute = 0;

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val == 1) cute++;
            else notCute++;
        }
        br.close();

        if (cute > notCute) System.out.println("Junhee is cute!");
        else System.out.println("Junhee is not cute!");
    }
}
