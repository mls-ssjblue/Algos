package codejam2020.round1b.expogo;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] solutions = new String[T];
        for (int i = 0; i < T; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();


            solutions[i] = expogo(x, y);
//            System.out.println(solutions[i]);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solutions[i]);
        }
    }

    private static String expogo(int x, int y) {
        StringBuilder ans = new StringBuilder();

        /*

            The idea is two move in the direction of the odd coordinate first (either away or towards) as
            the first move is the only chance to make an odd move(1).
            if x=5,y=6. The first move is either E or W. Assume you move E, then x is now x=4,y=6 and the jump length =2.
            This is equivalent to covering x=4/2 = 2, y=6/2 =3 with a jump length of 1. Repeat the process, whereby the
            odd coordinate is chosen first. To decide between E or W, x1=(x+1)/2,y1=y/2. if(x1+y) is odd, then there is
            a solution choosing 'W' and x=x1. Else if (x1+y) is even, there is no solution going west. Instead x=(x-1)/2
            and 'E' is chosen. In both cases y=y/2.
            Similarly, works for when y is odd.

         */
        if (Math.abs(x + y) % 2 != 1) return "IMPOSSIBLE";
        else {
            while ((x != 0) || (y != 0)) {
                System.out.println(x+ " "+y);

                if (Math.abs(x) + Math.abs(y) == 1) { // if only dist=1 is left to cover in any direction
                    if ((x == 0) && (y == 1)) ans.append('N');
                    else if ((x == 0) && (y == -1))
                        ans.append('S');
                    else if ((y == 0) && (x == 1))
                        ans.append('E');
                    else
                        ans.append('W');

                    break;
                }
                if (Math.abs(x) % 2 == 1) { //if x is odd , y is even
                    int y1 = y / 2, x1 = (x + 1) / 2;
                    if (Math.abs(x1 + y1) % 2 == 1) {
                        ans.append('W');
                        y = y1;
                        x = x1;
                    } else {
                        ans.append('E');
                        y = y1;
                        x = (x - 1) / 2;
                    }
                } else { // x is even, y is odd
                    int y1 = (y + 1) / 2, x1 = x / 2;
                    if (Math.abs(x1 + y1) % 2 == 1) {
                        ans.append('S');
                        y = y1;
                        x = x1;
                    } else {
                        ans.append('N');
                        y = (y - 1) / 2;
                        x = x1;
                    }
                }
//                System.out.println(x+ " "+y);

            }
        }
        return ans.toString();

    }
}
