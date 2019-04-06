package codejam.qualifying;

import java.util.Scanner;

import static java.lang.Math.pow;

class ForegoneSolution {
    private static long a;
    private static long b;
    private static long[] answer = new long[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] N = new long[T];
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextLong();
        }
        for (int i = 0; i < T; i++) {
            a = N[i];
            long[] results = findAnswer(a);
            System.out.println("Case #" + (i + 1) + ": " + results[0] + " " + results[1]);
        }


    }

    private static long[] findAnswer(long num) {
        long a = num;
        long b = num;
        int i = 1;
        while (a > 0) {
            long dig = a % 10;
            a = a / 10;
            if (dig == 4) {
                b = flip(b, i);
            }
            i++;
        }
        long[] answer = {b, num - b};
        return answer;
    }

    private static long flip(long b, int i) {
        long tenpower = (long) pow(10, i - 1);
        long mod = b % tenpower;
        b = b / tenpower;
        return b * tenpower + mod - tenpower;
    }


}
