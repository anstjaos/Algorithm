import java.io.*;

public class BOJ_5355 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");

            float num = Float.parseFloat(inputs[0]);

            for (int i = 1; i < inputs.length; i++) {
                String cur = inputs[i];

                switch (cur) {
                    case "@":
                        num = num * 3;
                        break;
                    case "%":
                        num += 5.0;
                        break;
                    case "#":
                        num -= 7.0;
                        break;
                }
            }

            sb.append(String.format("%.2f", num)).append("\n");
        }

        br.close();
        System.out.print(sb);
    }
}
