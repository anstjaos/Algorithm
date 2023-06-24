import java.util.Stack;

public class lvl2_60058 {
    public String solution(String p) {
        return dfs(p);
    }

    private String dfs(String w){
        if(w.length() == 0){
            return "";
        }

        String u = "";
        String v = "";
        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < w.length(); i++){
            if(w.charAt(i) == '('){
                leftCount++;
            } else rightCount++;

            u += w.charAt(i);
            if(leftCount == rightCount){
                v = w.substring(i + 1);
                break;
            }
        }

        if(isCorrect(u)){
            return u += dfs(v);
        }

        StringBuilder temp = new StringBuilder("(");
        temp.append(dfs(v));
        temp.append(")");
        u = u.substring(1, u.length()-1);

        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) =='('){
                temp.append(')');
            }else{
                temp.append('(');
            }
        }

        return temp.toString();
    }

    private boolean isCorrect(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return true;
    }
}
