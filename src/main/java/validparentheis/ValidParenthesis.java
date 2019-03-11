package validparentheis;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if(s.isEmpty()) return true;
        final int STRING_LENGTH = s.length();
        int lastOpen = 0;
        Stack<Character> openBraces = new Stack();
        int i =0;
        while(i < STRING_LENGTH ){
            if(isOpenBraces(s, i)){
                openBraces.push(s.charAt(i));
                i++;
                continue;
            }
            lastOpen = i -1;
            break;
        }
        int j = lastOpen + 1;
        while(j < STRING_LENGTH){
            if(openBraces.isEmpty()) return false;
            Character lastOpenChar = openBraces.pop();
            Character firstClose = s.charAt(j);
            if(isComplement(firstClose, lastOpenChar)){
                j ++;
            }
            else return false;
        }
        if(openBraces.isEmpty() != true) return false;
        return true;
    }

    private static boolean isComplement(char closed, Character open) {
        switch(open){
            case '{' : if(closed == '}'){
                return true;
            }
            case '[':  if(closed == ']'){
                return true;
            }
            case '(': if(closed == ')'){
                return true;
            }
            default: return  false;
        }
    }

    private static boolean isOpenBraces(String s, int i) {
        return s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(';
    }
}
