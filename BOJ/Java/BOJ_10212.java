import java.io.*;

public class BOJ_10212 {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

//        br.close();
        int minVal = 0;
        int maxVal = 1;
        int myTime = minVal + (int) (Math.random() * ((maxVal - minVal) + 1));

        String result = "Korea";
        if (myTime % 2 == 0) {
            result = "Yonsei";
        }
        System.out.print(result);
    }
}
