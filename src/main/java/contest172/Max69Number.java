package contest172;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Max69Number {
    @Test
    public void test(){
        Assertions.assertEquals(9969, max69(9669));
    }

    private int max69(int num) {
        Stack<Integer> s = new Stack();
        int fac = 1;
        while(num>0){
            s.push(num%10);
            num=num/10;
            fac*=10;
        }
        int newNum=0;
        int flag=0;
        while(!s.empty()){
            int dig = s.pop();
            if(dig==6 && flag==0){
                dig=9;
                flag=1;
            }
            newNum+=dig* fac/10;
            fac=fac/10;
        }
        return newNum;

    }
}
