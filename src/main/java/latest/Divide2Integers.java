package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Divide2Integers {
    @Test
     public void test(){
//        Assertions.assertEquals(3, divide(10,3));
//        Assertions.assertEquals(-2, divide(7,-3));
//        Assertions.assertEquals(2147483647, divide(-2147483648,-1));
        Assertions.assertEquals(2147483647, divide(2147483647,2));
    }

//    public int divide(int a, int b){
//        int q = 0;
//        if(a>0 && b >0){
//            while(a>=0){
//                a-=b;
//                if(q==2147483647) return q;
//                q++;
//            }
//            return (q-1);
//        }
//        else if ( a<0 && b < 0){
//            while(a<=0){
//                a-=b;
//                if(q==2147483647) return q;
//                q++;
//            }
//            return (q-1);
//        }
//        else if(a<0 && b> 0){
//            while(a<=0){
//                a+=b;
//                if(q==2147483647) return q*-1 -1;
//
//                q++;
//            }
//            return (q-1)*-1;
//        }
//        else if(a>0&& b<0){
//            while(a>=0){
//                a+=b;
//                if(q==2147483647) return q*-1 -1;
//                q++;
//            }
//            return (q-1)*-1;
//        }
//        return 0;
//    }

    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(dividend > 0 && divisor > 0) return divideHelper(-dividend, -divisor);
        else if(dividend > 0) return -divideHelper(-dividend,divisor);
        else if(divisor > 0) return -divideHelper(dividend,-divisor);
        else return divideHelper(dividend, divisor);
    }

    private int divideHelper(int dividend, int divisor){
        // base case
        if(divisor < dividend) return 0;
        // get highest digit of divisor
        int cur = 0, res = 0;
        while((divisor << cur) >= dividend && divisor << cur < 0 && cur < 31) cur++;
        res = dividend - (divisor << cur-1);
        if(res > divisor) return 1 << cur-1;
        return (1 << cur-1)+divide(res, divisor);
    }


//    public int divide(int dividend, int divisor) {
//        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
//        long absDividend = Math.abs((long) dividend);
//        long absDivisor = Math.abs((long) divisor);
//        long result = 0;
//        while(absDividend >= absDivisor){
//            long tmp = absDivisor, count = 1;
//            while(tmp <= absDividend){
//                tmp <<= 1;
//                count <<= 1;
//            }
//            result += count >> 1;
//            absDividend -= tmp >> 1;
//        }
//        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
//    }
}
