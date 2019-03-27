package atcoderq3;

import java.util.*;
import java.util.stream.Collectors;

//Reserving rooms question
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<Integer, List<Long>> occupiedRooms = new HashMap<>();
        for (int i = 0; i < M; i++) {
            occupiedRooms.put(i, Arrays.asList(sc.nextLong(), sc.nextLong()));
        }
        int Q = sc.nextInt();
        Map<Integer, List<Long>> queriedRooms = new HashMap<>();

        for (int i = 0; i < Q; i++) {
            long startRoom = sc.nextInt();
            long endRoom = sc.nextInt();
            queriedRooms.put(i, Arrays.asList(startRoom, endRoom));
            Boolean areRoomsAvailable = occupiedRooms.values()
                    .stream()
                    .map(rooms -> {
                        Long r1 = rooms.get(0);
                        Long r2 = rooms.get(rooms.size()-1);
                        if( (startRoom>=r1 && startRoom<=r2) || (endRoom>=r1 && endRoom<=r2 || (startRoom<=r1 && endRoom >=r2)))return true;
                        else return false;
                    })
                    .filter(val->val==true)
                    .collect(Collectors.toList())
                    .isEmpty();

            if(areRoomsAvailable){
                occupiedRooms.put(occupiedRooms.keySet().size(), Arrays.asList(startRoom, endRoom));
                System.out.println("OK");
            }
            else {
                System.out.println("NG");
            }

        }


    }
}
