package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WaterJug {

    @Test
    public void test() {
        Assertions.assertEquals(true, canMeasureWater(3, 5, 4));
        Assertions.assertEquals(false, canMeasureWater(2, 6, 5));
        Assertions.assertEquals(false, canMeasureWater(0, 0, 1));
        Assertions.assertEquals(false, canMeasureWater(1, 1, 12));
        Assertions.assertEquals(true, canMeasureWater(1, 2, 3));
        Assertions.assertEquals(false, canMeasureWater(1, 1, 12));
    }

    private boolean canMeasureWater(int x, int y, int z) {
        if(z > x + y) return false;
        if (z  % gcd(x, y)  == 0) return true;
        return false;
    }

    private int gcd(int num1, int num2){
        if(num1 == 0 || num2 == 0) return Integer.MAX_VALUE;
        int gcd = 1;
        for(int i = 1; i <= num1 && i <= num2; i++)
        {
            if(num1%i==0 && num2%i==0)
                gcd = i;
        }
        return gcd;
    }

}
