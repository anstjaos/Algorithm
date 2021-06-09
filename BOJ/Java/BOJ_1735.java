import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long aChild = Long.parseLong(st.nextToken()), aParent = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long bChild = Long.parseLong(st.nextToken()), bParent = Long.parseLong(st.nextToken());
        br.close();

        long parentGcd = getGcd(aParent, bParent);
        long resultParent = aParent * bParent / parentGcd;
        aChild = aChild * resultParent / aParent;
        bChild = bChild * resultParent / bParent;
        long resultChild = aChild + bChild;

        long resultGcd = getGcd(resultChild, resultParent);

        StringBuilder sb = new StringBuilder();
        sb.append(resultChild / resultGcd).append(" ").append(resultParent / resultGcd);
        System.out.println(sb);
    }

    private static long getGcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
