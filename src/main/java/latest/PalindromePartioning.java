package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PalindromePartioning {

//    Map<String,List<List<String>>> memo = new HashMap<>();

    Set<String> memo = new HashSet<>();

    @Test
    public void test() {

        List<List<String>> res = new ArrayList<>();
        res.add(Arrays.asList("a","b","bab"));
        res.add(Arrays.asList("a","b","b","a","b"));
        res.add(Arrays.asList("a","bb","a","b"));
        res.add(Arrays.asList("abba","b"));
        Assertions.assertEquals(res, partition("abbab"));
    }

//    Map<String,List<List<String>>> memo = new HashMap<>();

    public List<List<String>> partition(String s) {

        return partitionHelper(s);
    }

    private List<List<String>> partitionHelper(String s) {

        List<String> vals = new ArrayList<>();
//        if(memo.containsKey(s))return memo.get(s);
        if (s.length() == 1) {
            vals.add(s);
            List<List<String>> res = Arrays.asList(vals);
            memo.add(s);
//            memo.put(s,res);
            return res;
        }

        List<List<String>> palindromeSubStrings = new ArrayList<>();
        if (memo.contains(s) || (s.length()>0 && isPalindrome(s))) {
            if(!memo.contains(s)) memo.add(s);
            vals.add(s);
            palindromeSubStrings.add(vals);
        }
        for (int i = 0; i < s.length(); i++) {
            String firstPart = s.substring(0, i+1);
            if (memo.contains(firstPart) || isPalindrome(firstPart)) {
                if(!memo.contains(firstPart)) memo.add(firstPart);
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
