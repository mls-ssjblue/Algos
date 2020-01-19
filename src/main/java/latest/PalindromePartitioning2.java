package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PalindromePartitioning2 {

    Set<Boolean> memo = new HashSet<>();

    @Test
    public void test(){

        Assertions.assertEquals(1, minCut("aab"));
    }

    public int minCut(String s) {

        return 1;
    }

    private List<List<String>> partitionHelper(String s) {

        List<String> vals = new ArrayList<>();
//        if(memo.containsKey(s))return memo.get(s);
        if (s.length() == 1) {
            vals.add(s);
            List<List<String>> res = Arrays.asList(vals);
//            memo.put(s,res);
            return res;
        }

        List<List<String>> palindromeSubStrings = new ArrayList<>();
        if (s.length()>0 && isPalindrome(s)) {
            vals.add(s);
            palindromeSubStrings.add(vals);
        }
        for (int i = 0; i < s.length(); i++) {
            String firstPart = s.substring(0, i+1);
            if (isPalindrome(firstPart)) {
                List<List<String>> res = partitionHelper(s.substring(i+1));
                res.forEach(item -> {
                    List<String> tempItem = new ArrayList<>();
                    tempItem.add(firstPart);
                    tempItem.addAll(item);
                    palindromeSubStrings.add(tempItem);
                });
            }
        }
//        memo.put(s, palindromeSubStrings);

        return palindromeSubStrings;

    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
