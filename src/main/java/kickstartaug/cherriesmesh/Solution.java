package kickstartaug.cherriesmesh;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[]minSugar = new int[T];
        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            List<List<Integer>> cherrieconnections = new ArrayList<>();
            for(int j = 0; j < M ; j ++){
                int c = sc.nextInt();
                int d = sc.nextInt();
                cherrieconnections.add(Arrays.asList(c,d));
            }
            minSugar[i] = minSugar(N,M, cherrieconnections);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i+1) + ": " + minSugar[i]);
        }
    }

    private static int minSugar(int N, int M, List<List<Integer>> blackConnections){

        Set<Set<Integer>> groups = new HashSet<>();
        Set<Integer> connectedPoints = new HashSet<>();
        connectedPoints.add(blackConnections.get(0).get(0));
        connectedPoints.add(blackConnections.get(0).get(1));
        groups.add(connectedPoints);
        blackConnections.forEach(connection -> {
            for (Set<Integer> points : groups) {
                if(points.contains(connection.get(0)) || points.contains(connection.get(1))){
                    points.add(connection.get(0));
                    points.add(connection.get(1));
                }
                else {
                    Set<Integer> newGroup = new HashSet<>();
                    newGroup.add(connection.get(0));
                    newGroup.add(connection.get(1));
                    groups.add(newGroup);
                }
            }

        });

        Set<Integer> distinct = blackConnections.stream().flatMap(List::stream).collect(Collectors.toSet());
        long distinctConnectedCherries = distinct.size();
        int redStrandsNeeded = groups.size() - 1 + (N - (int)distinctConnectedCherries);

        long blackStandsNeeded = groups.stream().mapToLong(group -> group.size() - 1).sum();

        return (int)blackStandsNeeded + 2*(redStrandsNeeded);
    }
}




