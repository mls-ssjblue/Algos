package kickstartaug.streetcheckers;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static Map<Integer, Integer> gameDifference = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[]count = new int[T];
        for (int i = 0; i < T; i++) {

            int L = sc.nextInt();
            int R = sc.nextInt();
            count[i] = interestingGames(L,R);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i+1) + ": " + count[i]);
        }
    }

    private static int interestingGames(int l, int r) {
        long startTime = System.currentTimeMillis();
        int count = 0;
        for(int i = l ; i <= r; i++){

            int num = i;
            //get all divisors for num from (1,num)
            //count num even and odd divisors
            //if (diff(even, odd) <=2) count ++
            List<Integer> divisors = getDivisors(num);
            List<Integer> evenDivisors = divisors.stream().filter(div -> div%2==0).collect(Collectors.toList());
             divisors.removeAll(evenDivisors);
            int paintedTilesDifference = Math.abs(evenDivisors.size() - divisors.size());
            gameDifference.put(i,paintedTilesDifference);
            if(paintedTilesDifference <=2) count++;
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        return count;
   }

    private static List<Integer> getDivisors(int num) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num%i==0){
                ans.add(i);
                ans.add(num/i);
            }
        }

        return ans;
    }
}




