package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WildcardMatching {


    @Test
    public void test(){
//        Assertions.assertEquals(false, isMatch("aa", "a") );
//        Assertions.assertEquals(true, isMatch("aa", "*") );
//        Assertions.assertEquals(false, isMatch("cb", "a*") );
        Assertions.assertEquals(false, isMatch("mississippi", "m??*ss*?i*pi") );
        Assertions.assertEquals(false, isMatch("aaaa", "***a") );
        Assertions.assertEquals(false, isMatch("adceb", "*a*b") );
    }

    private boolean isMatch(String s, String p) {
        int j = 0;
        for(int i = 0 ; i < p.length(); i++){
            if(j == s.length()) return false;
            if(p.charAt(i) == '?'){
                j++;
            }
            else if (p.charAt(i) == '*'){
                if(i == p.length() - 1) return true;
                while(p.charAt(i) == '*'){
                    i++;
                }
                char next = p.charAt(i);
                if(next == '?'){
                    j++;
                    continue;
                }
                while(s.charAt(j) != next) j++;
            }
            else if(p.charAt(i) != s.charAt(j)) return false;
            else j++;
        }
        if (j == s.length() ) return true;
        return false;
    }
}
