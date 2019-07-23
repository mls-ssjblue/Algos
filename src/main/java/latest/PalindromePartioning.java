package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartioning {

    @Test
    public void test() {

        List<List<String>> res = new ArrayList<>();
        res.add(Arrays.asList("aa","b"));
        res.add(Arrays.asList("a", "a", "b"));
        Assertions.assertEquals(res, partition("bb"));
    }

    public List<List<String>> partition(String s) {

        return partitionHelper(s);
    }

    private List<List<String>> partitionHelper(String s) {

        List<String> vals = new ArrayList<>();
        if (s.length() == 1) {
            vals.add(s);
            return Arrays.asList(vals);
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
                    item.add(0, firstPart);
                    palindromeSubStrings.add(item);
                });

            }
        }

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
