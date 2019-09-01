package kickstartaug.streetcheckers;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    private static Map<Integer, Integer> gameDifference = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] count = new int[T];
        for (int i = 0; i < T; i++) {

            int L = sc.nextInt();
            int R = sc.nextInt();
            count[i] = interestingGames(L, R);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + count[i]);
        }
    }

    private static int interestingGames(int l, int r){
        int ans = 0;

        for (int i = l; i <= r; i++) {
            if (i % 4 == 2 || (i % 2 == 0 ? i / 4 : i) == 1 || BigInteger.valueOf(i % 2 == 0 ? i / 4 : i).isProbablePrime(20)) {
                ans++;
            }
        }
        return ans;
    }
//    private static int interestingGames(int l, int r) {
//        //case1: odd prime numbers in l, r
//        //case2: n -> 2*(2x+1) = 4x + 2
//        //case3: n%4==0? odd primes l/4, r/4
//        //case4: n==8
//        long startTime = System.currentTimeMillis();
////        int count = 0;
//        Set<Integer> interestingNumbers = new HashSet<>();
//        List<Integer> primes = numPrimes(r);
//        primes.removeAll(numPrimes(l-1));
//        interestingNumbers.addAll(primes);
//        List<Integer> primesBy4 = numPrimes(r/4);
//        primesBy4.removeAll(numPrimes(l/4));
//        interestingNumbers.addAll(primesBy4.stream().map(n->n*4).collect(Collectors.toList()));
////        count += numPrimes(r) - numPrimes(l-1);
////        count += numPrimes(r/4) - numPrimes(l/4-1);
//
//        for (int num = l; num <= r; num++) {
//            if (num == 8) interestingNumbers.add(8);
//            else if ((num - 2) % 4 == 0) interestingNumbers.add(num);
//        }
//        return interestingNumbers.size();
//    }

    private static boolean isOddPrime(int num) {
        if (num == 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    //seive of eratosthenes
    private static List<Integer> numPrimes(int num) {
        boolean[]A= new boolean[num];
        Arrays.fill(A,true);
        for(int i = 2; i <=Math.sqrt(num);i++){
            if(A[i-1]){
                for(int j = i*i; j<=num; j+=i){
                    A[j-1]=false;
                }
            }
        }
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<num;i++)if(A[i]) ans.add(i+1);
        return ans;
    }
}




