package contest172;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinTapsToOpenWaterGarden {
    @Test
    public void test(){
        int [] ranges={1,2,1,0,2,1,0,1};
        Assertions.assertEquals(3, minTaps(7,ranges));
    }

    private int minTaps(int n, int[]ranges) {
        int[][]intervals = new int[ranges.length][2];
        for(int i =0;i<ranges.length;i++){
            intervals[i][0] = i-ranges[i];
            intervals[i][1] = i+ranges[i];
        }

        Arrays.sort(intervals, (a, b) -> {
            int res = Integer.compare(a[0], b[0]);
            return res != 0 ? res : Integer.compare(b[1] - b[0], a[1] - a[0]);
        });

        int count=0;
        if(intervals[0][0]>0)return -1;
        if(intervals[0][1] >=n) return 1;
        count++;
        for(int i =1;i<intervals.length;i++){
            if(intervals[i][0] > intervals[i-1][1]) return -1;
            else {
                count++;
                if(intervals[i][1] >=n) break;
            }
        }
        return count;
    }

}
