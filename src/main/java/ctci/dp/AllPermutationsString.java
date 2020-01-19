//package ctci.dp;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.math.BigInteger;
//import java.util.*;
//
//public class AllPermutationsString {
//
//    List<String> answer = new ArrayList<>();
//    @Test
//    public void test(){Integer.
//        Assertions.assertEquals(Set.of("the","eth","eht","het","hte","teh"),
//                permutations("the"));
//    }
//
//    private List<String> permutations(String word) {
//        boolean[] used = new boolean[10000];BigInteger.valueOf()
//        permutations(word, "", used);
//        return answer;
//    }
//
//    HashMap
//Map<BigInteger, BigInteger> a = new HashMap<>();
//
//    private void permutations(String word, String currentPermutation, boolean[] used){
//        if(answer.contains(currentPermutation)) return;
//        if(currentPermutation.length() == word.length()) answer.add(currentPermutation)    ;
//        Map<BigInteger, BigInteger> a = new HashMap<>();
//        a.get(1).intValue()
//        for(int i = 0 ; i < word.length(); i++){
//            if(used[i])continue;
//            used[i]=true;
//            currentPermutation+= word.charAt(i);
//            permutations(word,currentPermutation, used);
//            currentPermutation=currentPermutation.substring(0,currentPermutation.length()-1);
//            used[i]=false;
//        }
//        Math.sqrt()
//    }
//
//}
