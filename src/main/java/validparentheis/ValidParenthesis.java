package validparentheis;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "{{}}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        int i = 0;
        Stack<Character> openBraceStack = new Stack<>();
        while (i < s.length()) {
            char currentChar = s.charAt(i);

            if (isOpenBraces(s, i)) {
                openBraceStack.push(currentChar);
                i++;
            } else if (openBraceStack.isEmpty()) return false;
            else {
                Character lastOpenBrace = openBraceStack.pop();
                if (isComplement(currentChar, lastOpenBrace)) i++;
                else return false;
            }
        }
        if(!openBraceStack.isEmpty()) return  false;
        else return true;
    }


    private static boolean isComplement(char closed, Character open) {
        switch(open){
            case '{' : if(closed == '}'){
                return true;
            }
            break;
            case '[':  if(closed == ']'){
                return true;
            }
            break;

            case '(': if(closed == ')'){
                return true;
            }

            default: return  false;
        }
        return false;
    }

    private static boolean isOpenBraces(String s, int i) {
        return s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(';
    }
}
