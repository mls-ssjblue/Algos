package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    @Test
    public void test() {

        Assertions.assertEquals(true, wordBreak("leetcode", Arrays.asList("leet", "code")));
        Assertions.assertEquals(true, wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        Assertions.assertEquals(true, wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));
        Assertions.assertEquals(false, wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        Assertions.assertEquals(true, wordBreak("aaaaaaa", Arrays.asList("aaa", "aaaa")));
    }

    public boolean wordBreak(String s, List<String> dict) {

        if (s == null || s.length() == 0) return false;

        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict

        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }

            /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
}