package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutation {

    private List<String> permutations = new ArrayList<>();
    private boolean[] used = new boolean[1000];

    @Test
    public void test() {
        Assertions.assertEquals(Arrays.asList("a1b2", "b1B2", "A1b2", "A1B2"), letterCasePermutation("a1b2"));
    }

    public List<String> letterCasePermutation(String word) {
        helper(word, "");
        return permutations;
    }

    private void helper(String original, String current) {
        if (current.length() == original.length()) {
            permutations.add(current);
            return;
        }
        int i = current.length();
        char c = original.charAt(i);
        if (c >= '0' && c <= '9') {
            helper(original, current + c);
            return;
        }
        helper(original, current + Character.toLowerCase(c));
        helper(original, current + Character.toUpperCase(c));
    }

}
