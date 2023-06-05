public class lvl2_77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if ((numbers[i] & 1) == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                StringBuilder temp = new StringBuilder();
                String binaryString = Long.toBinaryString(numbers[i]);
                if (!binaryString.contains("0")) {
                    temp.append("10");
                    temp.append(binaryString.substring(1));
                } else {
                    int lastIndex = binaryString.lastIndexOf("0");
                    int firstOneIndex = binaryString.indexOf("1", lastIndex);

                    temp.append(binaryString, 0, lastIndex).append("1");

                    temp.append("0");
                    temp.append(binaryString.substring(firstOneIndex + 1));
                }
                answer[i] = Long.parseLong(temp.toString(), 2);
            }
        }
        return answer;
    }
}
