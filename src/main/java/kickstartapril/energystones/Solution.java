package kickstartapril.energystones;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] N = new int[T];
        int[] maxEnergy = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextInt();
            int[] S = new int[N[i]];
            int[] E = new int[N[i]];
            int[] L = new int[N[i]];
            for (int j = 0; j < N[i]; j++) {
                S[j] = sc.nextInt();
                E[j] = sc.nextInt();
                L[j] = sc.nextInt();
            }
            maxEnergy[i] = findMaxEnergy(N[i], S, E, L);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i+1) + ": " + maxEnergy[i]);
        }
    }

    private static int findMaxEnergy(int numStones, int[] S, int[] E, int[] L) {
        List<Cost> costArrayList = new ArrayList<>();
        for (int j = 0; j < numStones; j++) {
            costArrayList.add(new Cost(j,calculateCost(S[j], E[j], L[j])));
        }


        costArrayList.sort(Comparator.comparingInt(a -> a.cost));

        int timeTaken = 0;
        int total = 0;
        for(Cost c: costArrayList){
            int index = c.index;
            int total1 = E[index] - timeTaken * L[index];
            total += total1 > 0?total1:0;
            timeTaken += S[index];
        }

        return total;
    }

    private static int calculateCost(int s, int e, int l) {
        return e * 2 - s - l;
    }


}

class Cost{
    int index;
    int cost;
    public Cost(int index, int cost){
        this.index = index;
        this.cost = cost;
    }
}


