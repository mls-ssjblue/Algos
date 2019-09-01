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
        //case1: odd prime numbers in l, r
        //case2: n -> 2*(2x+1) = 4x + 2
        //case3: n%4==0? odd primes l/4, r/4
        //case4: n==8
        long startTime = System.currentTimeMillis();
        int count = 0;

        for(int num= l;num<=r;num++){
            if(isOddPrime(num)) count++;
            else if((num-2)%4==0) count++;
            else if(num%4==0 && isOddPrime(num/4))count++;
            else if(num==8) count++;
        }
        return count;
   }

   private static boolean isOddPrime(int num){
        if(num==2) return false;
       for(int i = 2; i <= Math.sqrt(num); i++){
           if( num%i==0)return false;
       }
       return true;
   }
}




