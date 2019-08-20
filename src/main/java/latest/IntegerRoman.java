package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IntegerRoman {

    @Test
    public void test(){
        Assertions.assertEquals("III",intToRoman(3));
        Assertions.assertEquals("IV",intToRoman(4));
        Assertions.assertEquals("LVIII",intToRoman(58));
        Assertions.assertEquals("MCMXCIV",intToRoman(1994));
    }
    public String intToRoman(int num) {

        Map<Integer, String> intRomanMap = new HashMap<>();
        intRomanMap.put(1,"I");
        intRomanMap.put(4,"IV");
        intRomanMap.put(5,"V");
        intRomanMap.put(9,"IX");
        intRomanMap.put(10,"X");
        intRomanMap.put(40,"XL");
        intRomanMap.put(50,"L");
        intRomanMap.put(90,"XC");
        intRomanMap.put(100,"C");
        intRomanMap.put(400,"CD");
        intRomanMap.put(500,"D");
        intRomanMap.put(900,"CM");
        intRomanMap.put(1000,"M");

        StringBuilder sb = new StringBuilder();

        int weight = 1;
        while(num > 0){
            int dig = num % 10;
            int valToCheck = dig*weight;
            if(intRomanMap.containsKey(valToCheck)) {
                sb.insert(0,intRomanMap.get(valToCheck));
            }
            else {

                if(valToCheck < 4*weight){
                    sb.insert(0, String.join("", Collections.nCopies(dig,intRomanMap.get(weight))));
                }
                else {
                    sb.insert(0,String.join("", Collections.nCopies(dig-5,intRomanMap.get(weight))));
                    sb.insert(0,intRomanMap.get(5*weight));
                }

            }
            weight*=10;
            num=num/10;

        }
        return sb.toString();
    }

    public String intToRomanEasy(int num){
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
