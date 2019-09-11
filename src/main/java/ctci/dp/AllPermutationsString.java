package ctci.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AllPermutationsString {

    List<String> answer = new ArrayList<>();
    @Test
    public void test(){
        Assertions.assertEquals(Set.of("the","eth","eht","het","hte","teh"),
                permutations("the"));
    }

    private List<String> permutations(String word) {
        boolean[] used = new boolean[10000];
        permutations(word, "", used);
        return answer;
    }

    private void permutations(String word, String currentPermutation, boolean[] used){
        if(currentPermutation.length() == word.length() && !answer.contains(currentPermutation)) answer.add(currentPermutation)    ;

        for(int i = 0 ; i < word.length(); i++){
            if(used[i])continue;
            used[i]=true;
            currentPermutation+= word.charAt(i);
            permutations(word,currentPermutation, used);
            currentPermutation=currentPermutation.substring(0,currentPermutation.length()-1);
            used[i]=false;
        }
    }

}
