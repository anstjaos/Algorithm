import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11005 {
    private static char[] list = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        List<Character> convertList = new ArrayList<>();
        while (N != 0) {
            convertList.add(list[N % B]);
            N /= B;
        }

        StringBuilder sb = new StringBuilder();
        convertList.forEach(sb::append);
        System.out.println(sb.reverse());
    }
}
