package misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    Map<String, Boolean> memo = new HashMap<>();
    @Test
    public void test() {

        Assertions.assertEquals(true, wordBreak("leetcode", Arrays.asList("leet","code")));
        Assertions.assertEquals(false, wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        Assertions.assertEquals(true, wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        Assertions.assertEquals(true, wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if(memo.containsKey(s)) return memo.get(s);
        if(s.length() == 0) return true;
        for(int i = 0; i < s.length(); i ++){
            String sub = s.substring(0,i+1);
            if(wordDict.contains(sub)){
                boolean res = wordBreak(s.substring(i+1), wordDict);
                memo.put(s.substring(i + 1),res);
                if(res) return true;
            }
        }
        return false;
    }

}
