import java.util.*;

public class CheckForBrace {
    public static void main(String[] args){
        List<?extends Object> l;

        System.out.println(braces(new String[]{"{}[]()","{[}]","adfas{fs}cs("}));
    }
    static String[] braces(String[] values) {
        String[] result= new String[values.length];
        for(int i=0;i<values.length;i++){
            result[i]= checkString(values[i])? "YES" : "NO";
        }
        return result;

    }
    public static boolean checkString(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()) {
            if(c==')'||c=='('||c=='{'||c=='}'||c=='['||c==']') {
                if (map.containsKey(c)) {
                    Character peek = stack.isEmpty() ? null : stack.pop();
                    if (peek != map.get(c)) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}