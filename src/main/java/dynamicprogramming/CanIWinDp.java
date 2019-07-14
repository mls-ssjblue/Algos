package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
/* --------LOGIC ---------------

   The player who crosses the target wins the game. This problem can be solved
   recursively using a function canIWin(int n, int currentDesiredTotal, boolean[] chosen)
   where
   - n is the max of the number range allowed
   - currentDesiredTotal is the desired total at a given point in the game
   - chosen is an array of boolean to keep track of numbers chosen at a given point

   Taking a bottom up approach, the game ends when the current desired total <= 0. At
   this point, the function canIWin(n, currentDesiredTotal, chosen)
   returns true indicating that the player making the last move wins.

   Now, lets call the above function call - canIWin1(). This canIWin1() was called by
   a parent call canIWin2(). Each function call indicates that the turn is passed to
   the other player. This means that if canIWin1() is true (and assume that its player
   1 who is involved with this call), then canIWin2() must return false - (if player 1 wins
   in this combination of moves then player 2 must lose).

   canIWin2() (player 2's move) was triggered by canIWin3() (player 1's move).
   In each player's move, all possible unchosen numbers are chosen one by one
   and canIWin is called recursively with the following params:
    - n
    - currentDesiredTotal - i
    - chosen (after marking chosen[i] as true)

    in canIWinN+1() [Player 1 for example], there could be X number of recursive calls [Player 2]canIWinN1(),
    canIWinN2()....canIWinNX(). All these calls represent if player 2 can force a win
    over player 1 with each of the numbers chosen.

    If any of the above return true, then it means that player 1 can not force a
    win from the state at function canIWinN+1() call. Thus, canIWinN+1() returns
    false.
    If none of the above return true, then it means that player 2 could never
    force a win and thus player1 can force a win from canIWinN+1() stage onwards.





 */
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

        return !canIWin(N, target, new boolean[N]);
    }

    private boolean canIWin(int n, int currentDesiredTotal, boolean[] chosen) {

        if(currentDesiredTotal <= 0) return true;
        String chosenSerialization = Arrays.toString(chosen);
        if (memo.containsKey(chosenSerialization)) {
            return memo.get(chosenSerialization);
        }
        for(int i = 1; i <= n; i ++ ){
            if(chosen[i-1])continue;

            chosen[i-1] = true;

            if(canIWin(n, currentDesiredTotal - i, chosen)){
                memo.put(chosenSerialization, false);
                chosen[i-1] = false;
                return false;
            }
            chosen[i-1] = false;
        }
        memo.put(chosenSerialization, true);

        return true;
    }
}
