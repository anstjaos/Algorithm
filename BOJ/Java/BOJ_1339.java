import java.io.*;
import java.util.Arrays;

public class BOJ_1339 {
    private static String[] inputString = new String[15];
    private static int N;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            inputString[i] = br.readLine();
        }
        br.close();

        int[] alpha = new int[26];
        for(int i = 0; i < N; i++){
            int temp = (int)Math.pow(10, inputString[i].length() - 1);
            for(int j = 0; j < inputString[i].length(); j++){
                alpha[(int)inputString[i].charAt(j) - 'A'] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alpha);
        int index = 9;
        int sum = 0;
        for(int i = alpha.length - 1; i >= 0; i--){
            if(alpha[i] == 0){
                break;
            }
            sum += alpha[i] * index;
            index--;
        }
        System.out.println(sum);

    }

}
