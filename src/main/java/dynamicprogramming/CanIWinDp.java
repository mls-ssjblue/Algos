package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CanIWinDp {
    private static Map<String, Boolean> memo; // key: chosen[] to string, value: canIWinWithSituation return value when chosen to string is key

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
        List<Boolean> chosen = new ArrayList<>();
        for(int i = 0;i<N+1;i++) chosen.add(false);
        memo = new HashMap<>();

        return !canIWin(N, target, chosen);
    }

    private boolean canIWin(int n, int currentDesiredTotal, List<Boolean> chosen) {

        if(currentDesiredTotal <= 0) return true;
        String chosenSerialization = Arrays.toString(chosen.toArray());
        if (memo.containsKey(chosenSerialization)) {
            return memo.get(chosenSerialization);
        }
        for(int i = 1; i <= n; i ++ ){
            if(chosen.get(i-1))continue;

            int lastIndex = i-1;
            chosen.set(lastIndex,true);

            if(canIWin(n, currentDesiredTotal - i, chosen)){
                memo.put(chosenSerialization, false);
                chosen.set(lastIndex, false);
                return false;
            }
            chosen.set(lastIndex, false);
        }
        memo.put(chosenSerialization, true);

        return true;
    }
}
