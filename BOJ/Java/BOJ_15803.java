import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] arr = new double[2];
        int[][] input = new int[3][2];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        String result = "";
        if (input[0][1] == input[1][1] || input[0][1] == input[2][1] || input[1][1] == input[2][1]) {
            if(input[0][1] == input[1][1] && input[1][1] == input[2][1]) {
                result="WHERE IS MY CHICKEN?";
            } else {
                result="WINNER WINNER CHICKEN DINNER!";
            }
        } else if(input[0][0] == input[1][0] || input[1][0] == input[2][0] || input[0][0] == input[2][0]) {
            if(input[0][0] == input[1][0] && input[1][0] == input[2][0]) {
                result="WHERE IS MY CHICKEN?";
            } else {
                result="WINNER WINNER CHICKEN DINNER!";
            }
        } else {
            arr[0] = ((double)(input[1][0] - input[0][0]) / (double)(input[1][1] - input[0][1])) * 10 / 10;
            arr[1] = ((double)(input[2][0] - input[1][0]) / (double)(input[2][1] - input[1][1])) * 10 / 10;

            if (arr[0] == arr[1]) result="WHERE IS MY CHICKEN?";
            else result="WINNER WINNER CHICKEN DINNER!";
        }

        System.out.println(result);
    }
}
