package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CanIWinBackTracking {

    @Test
    public void test(){

       Assertions.assertEquals(true, canIWin(10,12));
       Assertions.assertEquals(false, canIWin(10,11));
       Assertions.assertEquals(false, canIWin(3,4));
       Assertions.assertEquals(false, canIWin(10,40));
       Assertions.assertEquals(true, canIWin(10,41));
       Assertions.assertEquals(true, canIWin(18,79));
    }

    public boolean canIWin(int N, int target){
        if(target <= N) return true;
        if(target > (N + 1)*N/2) return false;
        List<Integer> chosen = new ArrayList<>();
        return !canIWin(N, target, chosen);
    }

    private boolean canIWin(int n, int currentDesiredTotal, List<Integer> chosen) {

        if(currentDesiredTotal <= 0) return true;

        for(int i = 1; i <= n; i ++ ){
            if(chosen.contains(i))continue;

            chosen.add(i);
            int lastIndex = chosen.indexOf(i);

            if(canIWin(n, currentDesiredTotal - i, chosen)){
                chosen.remove(lastIndex);
                return false;
            }
            chosen.remove(lastIndex);
        }

        return true;
    }
}
