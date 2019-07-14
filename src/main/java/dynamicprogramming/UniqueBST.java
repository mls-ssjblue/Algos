package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniqueBST {

    //F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
    //G(n) = F(1, n) + F(2, n) + ... + F(n, n).
    //G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)

    @Test
    public void test(){
        Assertions.assertEquals(5, numTrees(3));
    }

    public static int numTrees(int n){

        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}
