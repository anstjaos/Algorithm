import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3425 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();
        final int MAX_VAL = 1000000000;
        while (true) {
            List<String> inputs = new ArrayList<>();

            boolean isQuit = false;
            while (true) {
                String input = br.readLine();
                if (input.isEmpty()) continue;
                if (input.equals("END")) break;
                if (input.equals("QUIT")) {
                    isQuit = true;
                    break;
                }
                inputs.add(input);
            }

            if (isQuit) break;

            int N = Integer.parseInt(br.readLine());
            int inputsLength = inputs.size();

            for (int i = 0; i < N; i++) {
                long num = Long.parseLong(br.readLine());
                Stack<Long> stack = new Stack<>();
                stack.push(num);

                boolean isError = false;
                for (int j = 0; j < inputsLength; j++) {
                    String curInput = inputs.get(j);

                    if (curInput.startsWith("N")) {
                        StringTokenizer st = new StringTokenizer(curInput);
                        st.nextToken();
                        stack.add(Long.parseLong(st.nextToken()));
                    } else if (curInput.charAt(0) == 'P') {
                        if (stack.isEmpty()) {
                            isError = true;
                            break;
                        }
                        stack.pop();
                    } else if (curInput.charAt(0) == 'I') {
                        if (stack.isEmpty()) {
                            isError = true;
                            break;
                        }

                        long curNum = stack.pop();
                        curNum *= -1;
                        stack.add(curNum);
                    } else if (curInput.startsWith("DU")) {
                        if (stack.isEmpty()) {
                            isError = true;
                            break;
                        }

                        stack.add(stack.peek());
                    } else if (curInput.startsWith("SW")) {
                        if (stack.size() < 2) {
                            isError = true;
                            break;
                        }

                        long firstNum = stack.pop();
                        long secondNum = stack.pop();

                        stack.add(firstNum);
                        stack.add(secondNum);
                    } else if (curInput.charAt(0) == 'A') {
                        if (stack.size() < 2) {
                            isError = true;
                            break;
                        }

                        long firstNum = stack.pop();
                        long secondNum = stack.pop();
                        long sum = secondNum + firstNum;
                        if (Math.abs(sum) > MAX_VAL) {
                            isError = true;
                            break;
                        }

                        stack.add(sum);
                    } else if (curInput.startsWith("SU")) {
                        if (stack.size() < 2) {
                            isError = true;
                            break;
                        }

                        long firstNum = stack.pop();
                        long secondNum = stack.pop();
                        long sub = secondNum - firstNum;
                        if (Math.abs(sub) > MAX_VAL) {
                            isError = true;
                            break;
                        }

                        stack.add(sub);
                    } else if (curInput.startsWith("MU")) {
                        if (stack.size() < 2) {
                            isError = true;
                            break;
                        }

                        long firstNum = stack.pop();
                        long secondNum = stack.pop();
                        long multi = secondNum * firstNum;
                        if (Math.abs(multi) > MAX_VAL) {
                            isError = true;
                            break;
                        }

                        stack.add(multi);
                    } else if (curInput.startsWith("DI")) {
                        if (stack.size() < 2) {
                            isError = true;
                            break;
                        }

                        int minusCount = 0;

                        long firstNum = stack.pop();
                        if (firstNum == 0) {
                            isError = true;
                            break;
                        }
                        if (firstNum < 0) minusCount++;
                        long secondNum = stack.pop();
                        if (secondNum < 0) minusCount++;

                        long div = Math.abs(secondNum) / Math.abs(firstNum);
                        if (minusCount == 1) {
                            div *= -1;
                        }
                        if (Math.abs(div) > MAX_VAL) {
                            isError = true;
                            break;
                        }

                        stack.add(div);
                    } else if (curInput.startsWith("MO")) {
                        if (stack.size() < 2) {
                            isError = true;
                            break;
                        }

                        long firstNum = stack.pop();
                        if (firstNum == 0) {
                            isError = true;
                            break;
                        }
                        long secondNum = stack.pop();

                        long mod = Math.abs(secondNum) % Math.abs(firstNum);
                        if (secondNum < 0) {
                            mod *= -1;
                        }
                        if (Math.abs(mod) > MAX_VAL) {
                            isError = true;
                            break;
                        }

                        stack.add(mod);
                    }
                }
                if (stack.size() != 1) isError = true;
                if (isError) sb.append("ERROR\n");
                else sb.append(stack.pop()).append("\n");
            }
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
