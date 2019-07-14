package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisorGame {

    @Test
    public void test(){

        Assertions.assertEquals(true, divisorGame(2));
    }

//    Choosing any x with 0 < x < N and N % x == 0.
//    Replacing the number N on the chalkboard with N - x.
    //21,18,15,12,9,6,3,2,1
    //21,18,15,10,5,[
    //2,1//3,2,1
    public boolean divisorGame(int N){

        return N%2==0;
    }


}
