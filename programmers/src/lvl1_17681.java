public class lvl1_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            char[] result = new char[n];

            int num = arr1[i];
            int curNum = (int) Math.pow(2, n - 1);

            int count = 0;
            while (curNum != 0) {
                if (curNum <= num) {
                    result[count] = '#';
                    num -= curNum;
                } else {
                    result[count] = '*';
                }
                count++;
                curNum /= 2;
            }

            num = arr2[i];
            curNum = (int) Math.pow(2, n - 1);
            count = 0;
            while (curNum != 0) {
                if (curNum <= num) {
                    result[count] = '#';
                    num -= curNum;
                } else {
                    if (result[count] != '#') {
                        result[count] = '*';
                    }
                }
                count++;
                curNum /= 2;
            }
            String r = "";
            for (int j = 0; j < n; j++) {
                if (result[j] == '*') r+= " ";
                else r+= '#';
            }
            answer[i] = r;
        }
        return answer;
    }
}
