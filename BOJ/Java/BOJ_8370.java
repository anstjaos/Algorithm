import java.io.*;

public class BOJ_8370 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String[] inputs = br.readLine().split(" ");
        int num = (Integer.parseInt(inputs[0]) * Integer.parseInt(inputs[1])) + (Integer.parseInt(inputs[2]) * Integer.parseInt(inputs[3]));
        System.out.println(num);
        br.close();
    }
}
