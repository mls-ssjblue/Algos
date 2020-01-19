package codechef.augustlunchtime;

import java.util.Scanner;

public class EqualAverage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[]count = new int[T];
        for (int i = 0; i < T; i++) {

            int L = sc.nextInt();
            int R = sc.nextInt();
//            count[i] = interestingGames(L,R);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i+1) + ": " + count[i]);
        }
    }

}
