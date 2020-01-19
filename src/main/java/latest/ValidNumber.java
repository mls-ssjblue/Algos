package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidNumber {
    @Test
    public void test(){

        Assertions.assertEquals(true, isNumber("0"));
        Assertions.assertEquals(true, isNumber("0.1"));
        Assertions.assertEquals(false, isNumber("abc"));
        Assertions.assertEquals(false, isNumber("1 a"));
        Assertions.assertEquals(true, isNumber("2e10"));
    }

    public boolean isNumber(String s){
return false;
    }
}
