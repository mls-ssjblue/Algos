package codechef.augustlunchtime;

import java.util.Scanner;

public class EidiGift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[]count = new String[T];
        int[] A = new int[3];
        int[] C = new int[3];
        for (int i = 0; i < T; i++) {
            for(int j = 0; j < 3;j++)
                A[j] = sc.nextInt();
            for(int j = 0; j < 3;j++)
                C[j] = sc.nextInt();
            count[i] = fairDistribution(A,C);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(count[i]);
        }
    }

    private static String fairDistribution(int[] a, int[] c) {
        double r1 = 1.0* a[0]/a[1];
        double r2 = 1.0*a[1]/a[2];
        double r3 = 1.0*a[0]/a[2];
        double d1 = 1.0*c[0]/c[1];
        double d2 = 1.0*c[1]/c[2];
        double d3 = 1.0*c[0]/c[2];
        if(r1 == 1 && d1 !=1 || r2 ==1 && d2!=1 || r3==1 && d3!=1) return "NOT FAIR";
        if(r1 != 1 && d1 ==1 || r2 !=1 && d2==1 || r3!=1 && d3==1) return "NOT FAIR";
        if( (r1-1) * (d1-1) <0 || (r2 -1)*(d2-1)<0 || (r3-1)*(d3-1)<0 ) return "NOT FAIR";
        return "FAIR";
     }
}
