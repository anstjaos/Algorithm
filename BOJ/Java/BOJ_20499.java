import java.io.*;

public class BOJ_20499 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] arr = br.readLine().split("/");
        br.close();

        boolean isReal = true;

        if (Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) < Integer.parseInt(arr[1]) || Integer.parseInt(arr[1]) == 0) isReal = false;

        if (isReal) System.out.println("gosu");
        else System.out.println("hasu");
    }
}
