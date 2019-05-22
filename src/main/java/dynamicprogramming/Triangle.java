package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.min;

public class Triangle {

    @Test
    public void test() {
        List<Integer> row1 = Arrays.asList(1);
        List<Integer> row2 = Arrays.asList(4, 5);
        List<Integer> row3 = Arrays.asList(2, 6, 3);
        List<List<Integer>> triangle = Arrays.asList(row1, row2, row3);
        Assertions.assertEquals(7, minimumTotal(triangle));

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minlen = new int[n + 1];
        for (int layer = n - 1; layer >= 0; layer--) // For each layer
        {
            for (int i = 0; i <= layer; i++) // Check its every 'node'
            {
                // Find the lesser of its two children, and sum the current value in the triangle with it.
                minlen[i] = min(minlen[i], minlen[i + 1]) + triangle.get(layer).get(i);
            }
        }
        return minlen[0];
    }
}
