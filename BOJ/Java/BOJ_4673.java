import java.util.Arrays;

public class BOJ_4673 {
    private static boolean[] isSelfNum;
    public static void main(String[] args)  {
        isSelfNum = new boolean[10006];
        Arrays.fill(isSelfNum, true);

        for (int i = 1; i <= 10000; i++) {
            int temp = i, sum = i;
            while (temp != 0) {
                sum += (temp % 10);
                temp /= 10;
            }
            if (sum > 10000) continue;
            isSelfNum[sum] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (isSelfNum[i]) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
