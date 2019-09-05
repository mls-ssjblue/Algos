package ctci.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MagicIndex {
    @Test
    public void test(){
        int[] a = {-5,-4,1,3,8,9};
        Assertions.assertEquals(3, magicIndex(a));
    }

    private int magicIndex(int[] a) {

        int low = 0, high = a.length-1, mid = (a.length)/2;
        while(low<high){
            if(a[mid] == mid) return mid;
            else if(a[mid] > mid){high = mid-1; mid = (low+high)/2;}
            else {low=mid+1;mid=(low+high)/2;}
        }
        return -1;
    }

    private int magicIndexNaive(int[] a) {
        for(int i = 0; i< a.length;i++){
            if(a[i]>i) return -1;
            else if (a[i]==i) return i;
        }
        return -1;
    }
}
