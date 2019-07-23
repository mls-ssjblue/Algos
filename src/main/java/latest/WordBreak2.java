package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WordBreak2 {
    Map<String, List<String>> memo = new HashMap<>();
    List<String> sentences = new ArrayList<>();

    @Test
    public void test(){
        Assertions.assertEquals(Arrays.asList("leet code"),
                wordBreak("leetcode", Arrays.asList("leet","code")));
        sentences = new ArrayList<>();
        Assertions.assertEquals(Collections.emptyList(),
                wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        sentences = new ArrayList<>();
        Assertions.assertEquals( Arrays.asList("pine apple pen apple",
                "pineapple pen apple",
                "pine applepen apple"),
                wordBreak("pineapplepenapple",
                        Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        Assertions.assertEquals( Arrays.asList("aaaa aaa", "aaa aaaa"),
                wordBreak("aaaaaaa",
                        Arrays.asList("aaaa", "aaa")));

    }

    private List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();
        return wordBreakUtil(s,wordDict);
    }


    private List<String> wordBreakUtil(String s, List<String> wordDict) {
        if(memo.containsKey(s)) return memo.get(s);
        if(s.length() == 0) {
            return Arrays.asList("");
        }
        List<String> newRes = new ArrayList<>();
        for(int i = 0; i < s.length(); i ++){
            String sub = s.substring(0,i+1);
            if(wordDict.contains(sub)){
                List<String> res = wordBreakUtil(s.substring(i+1), wordDict);
                for (String re : res) {
                    newRes.add(sub.concat(" " + re).trim());
                }

                memo.put(s,newRes);
            }
        }
        return newRes;
    }
}
