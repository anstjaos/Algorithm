import java.io.*;
import java.util.Stack;

public class BOJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        Stack<String> stack = new Stack<>();

        boolean isAble = true;
        for(int i=0; i < input.length(); i++) {
            String c = input.substring(i, i+1);

            if("(".equals(c)) {
                stack.push(")");
                continue;
            }

            if("[".equals(c)) {
                stack.push("]");
                continue;
            }

            int num = 0;
            while(true) {
                if(stack.isEmpty()) {
                    isAble = false;
                    break;
                }

                String top = stack.peek();
                if(!top.equals(")") && !top.equals("]")) {
                    num += Integer.parseInt(stack.pop());
                }else {
                    if(c.equals(top)) {
                        stack.pop();
                        int t = (")".equals(c)) ? 2:3;

                        if(num == 0) {
                            stack.push(String.valueOf(t));
                        }else {
                            stack.push(String.valueOf(t*num));
                        }
                        break;
                    }else {
                        isAble = false;
                        break;
                    }
                }
            }
            if(!isAble) break;
        }

        int result = 0;

        while(!stack.isEmpty()) {
            String top = stack.peek();
            if(!top.equals(")") && !top.equals("]")) {
                result += Integer.parseInt(stack.pop());
            }else {
                isAble = false;
                break;
            }
        }

        if (isAble) System.out.println(result);
        else System.out.println(0);
    }
}
