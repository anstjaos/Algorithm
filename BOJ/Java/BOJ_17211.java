import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17211 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double mood = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double[] arr = new double[4];
        for (int i = 0; i < 4; i++) arr[i] = Double.parseDouble(st.nextToken());
        br.close();

        mood = (1 - mood) * 1000;
        for (int i = 0; i < N; i++) {
            mood = mood * arr[0] + (1000 - mood) * arr[2];
        }

        System.out.println(String.format("%.0f", mood) + "\n" + String.format("%.0f", 1000 - mood));
    }
}
