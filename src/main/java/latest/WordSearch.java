package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordSearch {
    @Test
    public void test() {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        Assertions.assertEquals(true, exist(board, "ABCCED"));
        Assertions.assertEquals(true, exist(board, "SEE"));
        Assertions.assertEquals(false, exist(board, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {

        return true;
    }
}
